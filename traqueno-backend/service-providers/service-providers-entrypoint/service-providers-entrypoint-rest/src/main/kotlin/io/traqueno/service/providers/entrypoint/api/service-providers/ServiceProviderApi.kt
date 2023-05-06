package io.traqueno.service.providers.entrypoint.api.service.providers

import io.traqueno.service.providers.core.model.ServiceProvider
import io.traqueno.service.providers.core.service.ServiceProvidersService
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Tag(name = "ServiceProviderApi")
@Path("")
class ServiceProviderApi(
    private val serviceProvidersService : ServiceProvidersService
) {
    @GET
    @Path("/v1/serviceProviders/{serviceProviderId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getServiceProvider(@PathParam("serviceProviderId") serviceProviderId: String): ServiceProvider {
        return serviceProvidersService.getServiceProviderById(UUID.fromString(serviceProviderId))?.let {
            ServiceProvider(
                id = it.id,
                domain = it.domain,
                topic = it.topic,
                contact = it.contact,
                openingHours = it.openingHours
            )
        } ?: throw NotFoundException("Service provider '$serviceProviderId' not found")
    }
}