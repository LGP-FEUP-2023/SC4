package io.traqueno.service.providers.core.external

import io.traqueno.service.providers.core.model.ServiceProvider
import java.util.*

interface IServiceProvidersDatabase {
    fun putServiceProvider(serviceProvider: ServiceProvider): Boolean
    fun searchServiceProvidersWithNameLike(name: String): Array<ServiceProvider>
    fun getServiceProviderById(id: UUID): ServiceProvider?
}