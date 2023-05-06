package io.traqueno.service.providers.core.service

import io.traqueno.service.providers.core.external.IServiceProvidersDatabase
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ServiceProvidersService(
    private val serviceProviderDatabase: IServiceProvidersDatabase
) {
    fun register(firstName: String, lastName: String, email: String, password: String) {
    }

    fun login(email: String, password: String) {
    }

    fun getServiceProviderById(id: UUID) = serviceProviderDatabase.getServiceProviderById(id);

}