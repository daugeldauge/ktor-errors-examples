package com.example.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondBytes("�������".map { it.code.toByte() }.toByteArray(), ContentType.Application.Any)
        }
    }

}
