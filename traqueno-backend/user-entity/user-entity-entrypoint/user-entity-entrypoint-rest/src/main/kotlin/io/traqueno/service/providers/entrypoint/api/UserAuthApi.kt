package io.traqueno.service.providers.entrypoint.api

import io.traqueno.service.providers.entrypoint.api.model.LoginRequest
import io.traqueno.service.providers.entrypoint.api.model.LoginResponse
import io.traqueno.service.providers.entrypoint.api.model.RegisterRequest
import io.traqueno.service.providers.core.service.UserAuthService
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Tag(name = "AuthApi")
@Path("")
class UserAuthApi(
    private val userAuthService: UserAuthService
) {
    @POST
    @Path("/v1/user/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun login(
        loginRequest: LoginRequest
    ): LoginResponse {
        val jwt = userAuthService.login(loginRequest.email, loginRequest.password)

        return LoginResponse(jwt)
    }

    @POST
    @Path("/v1/user/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun register(registerRequest: RegisterRequest) {
        userAuthService.register(
            registerRequest.firstName,
            registerRequest.lastName,
            registerRequest.email,
            registerRequest.password
        )
    }
}