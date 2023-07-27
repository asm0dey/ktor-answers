/*
 * This file is generated by jOOQ.
 */
package io.ktor.answers.generated;


import io.ktor.answers.generated.tables.Answer;
import io.ktor.answers.generated.tables.Comment;
import io.ktor.answers.generated.tables.Content;
import io.ktor.answers.generated.tables.Question;
import io.ktor.answers.generated.tables.QuestionTag;
import io.ktor.answers.generated.tables.Role;
import io.ktor.answers.generated.tables.Tag;
import io.ktor.answers.generated.tables.UserRole;
import io.ktor.answers.generated.tables.Users;
import io.ktor.answers.generated.tables.Vote;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.answer</code>.
     */
    public final Answer ANSWER = Answer.ANSWER;

    /**
     * The table <code>public.comment</code>.
     */
    public final Comment COMMENT = Comment.COMMENT;

    /**
     * The table <code>public.content</code>.
     */
    public final Content CONTENT = Content.CONTENT;

    /**
     * The table <code>public.question</code>.
     */
    public final Question QUESTION = Question.QUESTION;

    /**
     * The table <code>public.question_tag</code>.
     */
    public final QuestionTag QUESTION_TAG = QuestionTag.QUESTION_TAG;

    /**
     * The table <code>public.role</code>.
     */
    public final Role ROLE = Role.ROLE;

    /**
     * The table <code>public.tag</code>.
     */
    public final Tag TAG = Tag.TAG;

    /**
     * The table <code>public.user_role</code>.
     */
    public final UserRole USER_ROLE = UserRole.USER_ROLE;

    /**
     * The table <code>public.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * The table <code>public.vote</code>.
     */
    public final Vote VOTE = Vote.VOTE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Answer.ANSWER,
            Comment.COMMENT,
            Content.CONTENT,
            Question.QUESTION,
            QuestionTag.QUESTION_TAG,
            Role.ROLE,
            Tag.TAG,
            UserRole.USER_ROLE,
            Users.USERS,
            Vote.VOTE
        );
    }
}
