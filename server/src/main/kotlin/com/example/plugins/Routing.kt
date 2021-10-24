package com.example.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.configureRouting() {
    routing {
        get("/malformed") {
            call.respondBytes("�������".map { it.code.toByte() }.toByteArray(), ContentType.Application.Any)
        }
        get("/empty") {
            call.respondBytes(byteArrayOf(), ContentType.Application.Any)
        }
        get("/error") {
            call.respondText("Error!", ContentType.Text.Plain, status = HttpStatusCode.InternalServerError)
        }
        get("/text") {
            call.respondText("Hello world", ContentType.Text.Plain)
        }
        get("/fakejson") {
            call.respondText("}}{{", ContentType.Application.Json)
        }

    }

}
