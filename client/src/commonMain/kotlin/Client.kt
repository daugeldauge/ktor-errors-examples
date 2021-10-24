package com.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException

@Serializable
class Response(val one: String, val another: String)

suspend fun makeRequests() {
    HttpClient {
        install(JsonFeature)
    }.apply {
        check("malformed")
        check("empty")
        check("error")
        check("text")
        check("fakejson")
    }


}

suspend fun HttpClient.check(path: String) {
    val response = try {
        get<Response>("http://localhost:8080/$path")
    } catch (e: ResponseException) {
        e
    } catch (e: IOException) {
        e
    } catch (e: SerializationException) {
        e
    } catch (e: NoTransformationFoundException) {
        e
    }

    println("path: $path\t response: $response")
}
