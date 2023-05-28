package io.traqueno.service.provider.entity.service

import io.traqueno.service.provider.entity.exception.NotFoundException
import io.traqueno.service.provider.entity.model.Service
import io.traqueno.service.provider.entity.repository.ServiceRepository
import io.traqueno.service.provider.entity.request.ServiceRequest
import java.util.*

@org.springframework.stereotype.Service
class ServicesService(
    private val serviceRepository: ServiceRepository
) {
    fun createService(request: ServiceRequest): Service {

       return serviceRepository.save(
            Service(
                id = UUID.randomUUID().toString(),
                name = request.name,
                serviceType = request.servicesType
            )
        )
    }


    fun findAll(): List<Service> =
        serviceRepository.findAll()

    fun findById(id: String): Service =
        serviceRepository.findById(id)
            .orElseThrow { NotFoundException("Service with id $id not found") }
}