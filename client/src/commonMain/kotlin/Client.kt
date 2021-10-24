package com.example

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
class Response(val one: String, val another: String)

suspend fun makeRequest() {
    val client = HttpClient {
        install(JsonFeature)
    }

    println(client.get<Response>("http://localhost:8080/"))
}
