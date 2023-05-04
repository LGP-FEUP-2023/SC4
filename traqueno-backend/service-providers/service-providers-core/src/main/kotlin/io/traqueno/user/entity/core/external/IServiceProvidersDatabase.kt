package io.traqueno.user.entity.core.external

import io.traqueno.user.entity.core.model.User

interface IServiceProvidersDatabase {
    fun putServiceProvider(newUser: User): Boolean
    fun getServiceProviderByName(name: String): ServiceProvider?
    fun getServiceProviderById(id: UUID): ServiceProvider?
}