package io.traqueno.service.provider.entity.repository

import io.traqueno.service.provider.entity.model.ServiceProviderCategory
import org.springframework.data.mongodb.repository.MongoRepository

interface ServiceProviderCategoryRepository : MongoRepository<ServiceProviderCategory, String> {
}