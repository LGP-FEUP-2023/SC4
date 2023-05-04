package io.traqueno.service.providers.entrypoint.api.user.providers

import io.traqueno.user.entity.core.service.UserAuthService
import io.traqueno.user.entity.entrypoint.api.auth.model.GetUserResponse
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Tag(name = "ServiceProviderApi")
@Path("")
class ServiceProviderApi(
    private val serviceProvidersService: Se
) {
    @GET
    @Path("/v1/serviceProviders/{serviceProviderId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getServiceProvider(@PathParam("serviceProviderId") serviceProviderId: String): ServiceProvider {
        return userAuthService.getServiceProvider(serviceProviderId)?.let {
            GetUserResponse(it.firstName, it.lastName, it.email, it.userId.toString())
        } ?: throw NotFoundException("Service provider '$serviceProviderId' not found")
    }
}