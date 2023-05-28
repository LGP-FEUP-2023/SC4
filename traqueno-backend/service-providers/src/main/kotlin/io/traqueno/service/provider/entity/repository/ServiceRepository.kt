package io.traqueno.service.provider.entity.repository

import io.traqueno.service.provider.entity.model.Service
import org.springframework.data.mongodb.repository.MongoRepository

interface ServiceRepository : MongoRepository<Service, String> {
}