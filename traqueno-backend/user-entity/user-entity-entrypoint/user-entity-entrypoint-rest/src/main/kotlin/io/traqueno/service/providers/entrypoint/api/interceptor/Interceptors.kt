package io.traqueno.service.providers.entrypoint.api.interceptor

import io.quarkus.logging.Log
import org.jboss.logging.Logger
import javax.ws.rs.container.ContainerRequestContext

import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.ext.Provider

@Provider
class SecurityInterceptor : ContainerRequestFilter {
    override fun filter(context: ContainerRequestContext) {
        Log.info("Start of request")
    }
}