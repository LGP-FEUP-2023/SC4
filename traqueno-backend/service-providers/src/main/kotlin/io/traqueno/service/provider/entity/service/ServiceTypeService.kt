package io.traqueno.service.provider.entity.service

import io.traqueno.service.provider.entity.exception.NotFoundException
import io.traqueno.service.provider.entity.model.ServiceType
import io.traqueno.service.provider.entity.repository.ServiceTypeRepository
import io.traqueno.service.provider.entity.request.ServiceTypeRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServiceTypeService(
    private val serviceTypeRepository: ServiceTypeRepository
) {
    fun createServiceType(request: ServiceTypeRequest): ServiceType =
        serviceTypeRepository.save(
            ServiceType(
                //id = UUID.randomUUID().toString(),
                name = request.name,
                duration = request.duration,
                price = request.price,
                currency = request.currency
            )
        )

    fun findAll(): List<ServiceType> =
        serviceTypeRepository.findAll()

    fun findById(id: String): ServiceType =
        serviceTypeRepository.findById(id)
            .orElseThrow { NotFoundException("Service Type with id $id not found") }
}