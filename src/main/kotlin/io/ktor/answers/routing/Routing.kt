package io.ktor.answers.routing

import io.ktor.answers.db.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jooq.DSLContext

fun Application.configureRouting(dsl: DSLContext) {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        val userRepository = UserRepository(dsl) // TODO DI
        usersRouting(userRepository)
    }
}
