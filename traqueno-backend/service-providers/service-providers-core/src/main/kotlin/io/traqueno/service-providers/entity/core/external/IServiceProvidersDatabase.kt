package io.traqueno.service.providers.entity.core.external

import io.traqueno.service.providers.entity.core.model.ServiceProvider

interface IServiceProvidersDatabase {
    fun putServiceProvider(serviceProvider: ServiceProvider): Boolean
    fun searchServiceProvidersWithNameLike(name: String): ServiceProvider[]?
    fun getServiceProviderById(id: UUID): ServiceProvider?
}