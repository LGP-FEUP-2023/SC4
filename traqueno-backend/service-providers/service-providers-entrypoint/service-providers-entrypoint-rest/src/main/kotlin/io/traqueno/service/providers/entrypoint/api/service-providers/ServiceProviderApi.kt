package io.traqueno.service.providers.entrypoint.api.service.providers

import io.traqueno.service.providers.core.model.Service
import io.traqueno.service.providers.core.model.ServiceCategory
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
    @Path("/v1/categories")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllCategories(): Array<ServiceCategory> {
        throw NotImplementedError()
    }

    @GET
    @Path("/v1/serviceProviders")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllServiceProviders(): Array<ServiceProvider> {
        throw NotImplementedError()
    }

    @GET
    @Path("/v1/serviceProviders/{serviceProviderId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getServiceProvider(@PathParam("serviceProviderId") serviceProviderId: String): ServiceProvider? {
        throw NotImplementedError()
    }

    @GET
    @Path("/v1/serviceProviders/{serviceProviderId}/services")
    @Produces(MediaType.APPLICATION_JSON)
    fun getServices(@PathParam("serviceProviderId") serviceProviderId: String): Array<Service> {
        throw NotImplementedError()
    }
}