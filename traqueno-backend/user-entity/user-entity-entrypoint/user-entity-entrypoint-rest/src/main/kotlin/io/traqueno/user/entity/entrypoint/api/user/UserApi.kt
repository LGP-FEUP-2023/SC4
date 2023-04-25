package io.traqueno.user.entity.entrypoint.api.user

import io.traqueno.user.entity.core.service.UserAuthService
import io.traqueno.user.entity.entrypoint.api.auth.model.GetUserResponse
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Tag(name = "UserApi")
@Path("")
class UserApi(
    private val userAuthService: UserAuthService
) {
    @GET
    @Path("/v1/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUser(@PathParam("userId") userId: String): GetUserResponse {
        return userAuthService.getUser(userId)?.let {
            GetUserResponse(it.firstName, it.lastName, it.email, it.userId.toString())
        } ?: throw NotFoundException("User '$userId' not found")
    }
}