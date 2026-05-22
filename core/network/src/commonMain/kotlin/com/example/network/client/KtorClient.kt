package com.example.network.client

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.http.parameters
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.math.log

internal fun createKtorClient(): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
        /*install(Logging) {
            logger = Logger.ANDROID
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }*/
        install(HttpTimeout) {
            requestTimeoutMillis = 30_000
            connectTimeoutMillis = 15_000
            socketTimeoutMillis = 30_000
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v("Ktor Client: ", null, message)
                }
            }
            level = LogLevel.BODY
        }.also {
            Napier.base(DebugAntilog("KtorClient"))
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.BODY
        }
        install(HttpCache)
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = Secret.HOST
                path(Secret.PATH)
                parameters.append("key", Secret.KEY)
            }
        }
    }
}