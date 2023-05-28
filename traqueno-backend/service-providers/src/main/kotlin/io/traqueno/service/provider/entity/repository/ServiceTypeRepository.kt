package io.traqueno.service.provider.entity.repository

import io.traqueno.service.provider.entity.model.ServiceType
import org.springframework.data.mongodb.repository.MongoRepository

interface ServiceTypeRepository: MongoRepository<ServiceType, String> {
}