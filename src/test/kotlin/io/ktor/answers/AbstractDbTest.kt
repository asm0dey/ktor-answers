package io.ktor.answers

import org.jetbrains.exposed.sql.Database
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy
import java.time.Duration

abstract class AbstractDbTest {
    companion object {
        var dsl: DSLContext

        @JvmField
        val postgres = PostgreSQLContainer("postgres")
            .waitingFor(HostPortWaitStrategy())

        init {
            postgres.start()
            val url = postgres.jdbcUrl
            val user = postgres.username
            val password = postgres.password
            migrate(url, user, password)
            Database.connect(url, user = user, password = password)
            dsl = DSL.using(url, user, password)
        }
    }
}