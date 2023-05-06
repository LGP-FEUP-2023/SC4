package io.traqueno.service.providers.entrypoint.api

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.servers.Server
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

/**
 * This class makes sure that the application is loaded by Quarkus.
 */
@ApplicationPath("/api/user-entity")
@OpenAPIDefinition(
    info = Info(
        version = "0.0.1",
        title = "User-Entity",
        description = "This service provides ..."
    ),
    servers = [
        Server(
            description = "Traqueno Backend API",
            url = "/"
        )
    ]
)
class App : Application()