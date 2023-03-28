package com.example.plugins

import io.ktor.server.plugins.openapi.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.plugins.hsts.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.http.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.application.*

fun Application.configureHTTP() {
    routing {
        openAPI(path = "openapi")
    }
    routing {
        swaggerUI(path = "openapi")
    }
    install(HSTS) {
        includeSubDomains = true
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        allowHeader("MyCustomHeader")
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }
}
