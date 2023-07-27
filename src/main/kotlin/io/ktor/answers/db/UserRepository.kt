package io.ktor.answers.db

import io.ktor.answers.generated.public_.Tables.*
import io.ktor.answers.generated.public_.tables.records.*
import io.ktor.answers.model.*
import io.ktor.answers.routing.*
import kotlinx.coroutines.Dispatchers
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone.Companion.UTC
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.JoinType.INNER
import org.jetbrains.exposed.sql.JoinType.LEFT
import org.jetbrains.exposed.sql.SortOrder.ASC
import org.jetbrains.exposed.sql.SqlExpressionBuilder.coalesce
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.greaterEq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.inList
import org.jetbrains.exposed.sql.SqlExpressionBuilder.lessEq
import org.jetbrains.exposed.sql.kotlin.datetime.date
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jooq.DSLContext
import org.jooq.DataType
import org.jooq.Field
import org.jooq.TableField
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.jooq.kotlin.coroutines.transactionCoroutine

val defaultQueryParams = CommonQueryParams(0, 20, null, null, null, ASC)

class UserRepository(val dsl: DSLContext) {
    suspend fun allUsers(
        parsed: CommonQueryParams = defaultQueryParams,
    ): List<User> = dsl.transactionCoroutine {
        var cond = USERS.ACTIVE.isTrue
        if (parsed.fromDate != null) cond =
            cond.and(USERS.CREATED_AT.greaterOrEqual(parsed.fromDate.toJavaLocalDate().atStartOfDay()))
        if (parsed.toDate != null) cond =
            cond.and(USERS.CREATED_AT.lessThan(parsed.toDate.toJavaLocalDate().atStartOfDay()))
        it.dsl()
            .selectFrom(USERS)
            .where(cond)
            .orderBy(
                when (parsed.sortBy ?: "name") {
                    "name" -> USERS.NAME
                    "creation" -> USERS.CREATED_AT
                    else -> error("Unsupported sort column: ${parsed.sortBy}")
                }
            )
            .asSequence()
            .map(::toUser)
            .toList()
    }

    suspend fun userById(id: Long): UserDAO? = suspendTransaction {
        UserDAO
            .find { (UserTable.id eq id) and (UserTable.active eq true) }
            .limit(1).firstOrNull()
    }

    suspend fun usersByIds(
        ids: List<Long>,
        queryParams: CommonQueryParams = defaultQueryParams,
    ): List<User> = dsl.transactionCoroutine {
        var cond = USERS.ACTIVE.isTrue.and(USERS.ID.`in`(ids))
        if (queryParams.fromDate != null)
            cond = cond.and(USERS.CREATED_AT.greaterOrEqual(queryParams.fromDate.toJavaLocalDate().atStartOfDay()))
        if (queryParams.toDate != null)
            cond = cond.and(USERS.CREATED_AT.lessThan(queryParams.toDate.toJavaLocalDate().atStartOfDay()))
        it.dsl()
            .selectFrom(USERS)
            .where(cond)
            .orderBy(
                when (queryParams.sortBy ?: "name") {
                    "name" -> USERS.NAME
                    "creation" -> USERS.CREATED_AT
                    else -> error("Unsupported sort column: ${queryParams.sortBy}")
                }.sortBy(queryParams)
            )
            .limit(
                if (queryParams.page != null) queryParams.pageSize.toLong() * (queryParams.page - 1) else 0,
                queryParams.pageSize
            )
            .asSequence()
            .map (::toUser)
            .toList()
    }
    private fun Field<*>.sortBy(queryParams: CommonQueryParams) = if (queryParams.order.name.startsWith("ASC")) sortAsc() else sortDesc()

    private fun toUser(usersRecord: UsersRecord) = User(
        usersRecord[USERS.ID],
        usersRecord[USERS.NAME],
        usersRecord[USERS.ACTIVE],
        usersRecord[USERS.EMAIL],
        usersRecord[USERS.CREATED_AT].toKotlinLocalDateTime().toInstant(UTC),
        usersRecord[USERS.DISPLAY_NAME],
        usersRecord[USERS.LOCATION],
        usersRecord[USERS.ABOUT_ME],
        usersRecord[USERS.LINK]
    )

    suspend fun commentsByIds(
        ids: List<Long>,
        queryParams: CommonQueryParams = defaultQueryParams,
    ): List<Comment> = dsl.transactionCoroutine {
        val text = DSL.min(CONTENT.TEXT)
        val createdAt = DSL.min(CONTENT.CREATED_AT)
        val author = DSL.min(CONTENT.AUTHOR_ID)
        val votes = DSL.coalesce(DSL.sum(VOTE.CONTENT).cast(SQLDataType.INTEGER), 0)
        it.dsl()
            .select(COMMENT.ID, text, createdAt, author, votes)
            .from(COMMENT)
            .innerJoin(CONTENT).on(COMMENT.DATA.eq(CONTENT.ID))
            .innerJoin(USERS).on(CONTENT.AUTHOR_ID.eq(USERS.ID))
            .leftJoin(VOTE).on(VOTE.CONTENT.eq(CONTENT.ID))
            .where(COMMENT.ID.`in`(ids))
            .groupBy(COMMENT.ID)
            .orderBy(
                when (queryParams.sortBy ?: "creation") {
                    "creation" -> createdAt
                    "votes" -> votes
                    else -> error("Unsupported sort predicate: ${queryParams.sortBy}")
                }.sortBy(queryParams)
            )
            .limit(
                if (queryParams.page != null) queryParams.pageSize.toLong() * (queryParams.page - 1) else 0,
                queryParams.pageSize
            )
            .asSequence()
            .map {
                Comment(
                    it[COMMENT.ID],
                    it[text],
                    it[createdAt].toKotlinLocalDateTime().toInstant(UTC),
                    it[author],
                    it[votes]
                )
            }
            .toList()
    }

    suspend fun questionsByIds(
        ids: List<Long>,
        queryParams: CommonQueryParams = defaultQueryParams,
    ): List<Question> = suspendTransaction {
        val text = ContentTable.text.min().alias("question_text")
        val createdAt = ContentTable.createdAt.min().alias("question_created")
        val author = ContentTable.author.min().alias("author")
        val votes = Coalesce(VoteTable.value.sum(), shortLiteral(0)).alias("votes")
        val questionTitle = QuestionTable.title.min().alias("question_title")
        QuestionTable
            .join(ContentTable, INNER, QuestionTable.data, ContentTable.id)
            .join(UserTable, INNER, ContentTable.author, UserTable.id)
            .join(VoteTable, LEFT, VoteTable.content, ContentTable.id)
            .slice(QuestionTable.id, questionTitle, text, createdAt, author, votes)
            .select { contentFilters(ids, queryParams.fromDate, queryParams.toDate) }
            .groupBy(QuestionTable.id)
            .limit(
                queryParams.pageSize,
                if (queryParams.page != null) queryParams.pageSize.toLong() * (queryParams.page - 1) else 0
            )
            .orderBy(
                when (queryParams.sortBy ?: "title") {
                    "creation" -> createdAt
                    "votes" -> votes
                    "title" -> questionTitle
                    else -> error("Unsupported sort predicate: ${queryParams.sortBy}")
                }, queryParams.order
            )
            .map {
                Question(
                    it[QuestionTable.id].value,
                    it[questionTitle]!!,
                    it[text]!!,
                    it[createdAt]!!,
                    it[author]!!.value,
                    it[votes].toInt()
                )
            }

    }

    suspend fun answersByIds(
        ids: List<Long>,
        queryParams: CommonQueryParams = defaultQueryParams,
    ): List<Answer> = suspendTransaction {
        val text = ContentTable.text.min().alias("question_text")
        val createdAt = ContentTable.createdAt.min().alias("question_created")
        val author = ContentTable.author.min().alias("author")
        val votes = Coalesce(VoteTable.value.sum(), shortLiteral(0)).alias("votes")
        AnswerTable
            .join(ContentTable, INNER, AnswerTable.data, ContentTable.id)
            .join(UserTable, INNER, ContentTable.author, UserTable.id)
            .join(VoteTable, LEFT, VoteTable.content, ContentTable.id)
            .slice(AnswerTable.id, text, createdAt, author, votes)
            .select { contentFilters(ids, queryParams.fromDate, queryParams.toDate) }
            .groupBy(AnswerTable.id)
            .limit(
                queryParams.pageSize,
                if (queryParams.page != null) queryParams.pageSize.toLong() * (queryParams.page - 1) else 0
            )
            .orderBy(
                when (queryParams.sortBy ?: "creation") {
                    "creation" -> createdAt
                    "votes" -> votes
                    else -> error("Unsupported sort predicate: ${queryParams.sortBy}")
                }, queryParams.order
            )
            .map {
                Answer(
                    it[AnswerTable.id].value,
                    it[text]!!,
                    it[createdAt]!!,
                    it[author]!!.value,
                    it[votes].toInt()
                )
            }

    }

    private fun contentFilters(
        userIds: List<Long>,
        fromDate: LocalDate?,
        toDate: LocalDate?
    ): Op<Boolean> {
        val inIds = UserTable.id inList userIds
        val active = UserTable.active eq true
        val from =
            if (fromDate != null) (ContentTable.createdAt.date() greaterEq fromDate) else null
        val to =
            if (toDate != null) ContentTable.createdAt.date() lessEq toDate else null
        return listOfNotNull(inIds, active, from, to).compoundAnd()
    }
}

suspend fun <T> suspendTransaction(block: Transaction.() -> T): T =
    newSuspendedTransaction(Dispatchers.IO, statement = block)
