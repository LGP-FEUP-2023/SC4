package io.traqueno.service.provider.entity.service

import io.traqueno.service.provider.entity.model.ServiceProvider
import io.traqueno.service.provider.entity.repository.ServiceProviderRepository
import io.traqueno.service.provider.entity.request.ServiceProviderRequest
import io.traqueno.service.provider.entity.response.ServiceProviderResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServiceProviderService(
    private val serviceProviderRepository: ServiceProviderRepository,
    private val categoryService: CategoryService
) {

    fun createServiceProvider(request: ServiceProviderRequest): ServiceProvider {
        val category = request.categoryId?.let { categoryService.findById(it) }

        return serviceProviderRepository.save(
            ServiceProvider(
                id = UUID.randomUUID().toString(),
                name = request.name,
                contact = request.contact,
                location = request.location,
                openingHours = request.openingHours,
                description = request.description,
                category = category,
                services = request.services,
                employee = request.employees

            )
        )
    }


    fun findById(id: String): ServiceProvider? {
        return serviceProviderRepository.findByIdOrNull(id)
    }

    fun existByName(name: String): Boolean {
        return serviceProviderRepository.existsByName(name);
    }

    fun findAllServiceProviders(): ResponseEntity<List<ServiceProviderResponse>> {
        val serviceProvides = serviceProviderRepository.findAll()

        return ResponseEntity
            .ok(
                serviceProvides.map { ServiceProviderResponse.fromEntity(it) }
            )
    }

    fun findAllByCategoryId(category: String): ResponseEntity<List<ServiceProviderResponse>> {
        val serviceProvides = serviceProviderRepository.findAllByCategory_Id(category)

        return ResponseEntity
            .ok(
                serviceProvides.map { ServiceProviderResponse.fromEntity(it) }
            )
    }

}