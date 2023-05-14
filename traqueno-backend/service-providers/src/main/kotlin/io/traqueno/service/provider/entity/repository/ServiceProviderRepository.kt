package io.traqueno.service.provider.entity.repository

import io.traqueno.service.provider.entity.model.ServiceProvider
import org.springframework.data.mongodb.repository.MongoRepository

interface ServiceProviderRepository : MongoRepository<ServiceProvider, String> {
    fun findByName(name: String): ServiceProvider?
    fun existsByName(name: String): Boolean
}