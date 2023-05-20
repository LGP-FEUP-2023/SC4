package io.traqueno.service.provider.entity.service

import io.traqueno.service.provider.entity.model.ServiceProvider
import io.traqueno.service.provider.entity.repository.ServiceProviderCategoryRepository
import io.traqueno.service.provider.entity.repository.ServiceProviderRepository
import io.traqueno.service.provider.entity.request.ServiceProviderRequest
import io.traqueno.service.provider.entity.response.CategoriesResponse
import io.traqueno.service.provider.entity.response.ServiceProviderResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServiceProviderService(
    private val serviceProviderRepository: ServiceProviderRepository,
    private val serviceProviderCategoryRepository: ServiceProviderCategoryRepository
) {

    fun createServiceProvider(request: ServiceProviderRequest): ServiceProvider =
        serviceProviderRepository.save(
            ServiceProvider(
                id = UUID.randomUUID().toString(),
                name = request.name,
                category = request.category,
                contact = request.contact,
                location = request.location,
                openingHours = request.openingHours,
                description = request.description
            )
        )

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

    fun findAllByCategoryEquals(category: String): ResponseEntity<List<ServiceProviderResponse>> {
        val serviceProvides = serviceProviderRepository.findAllByCategoryEquals(category)

        return ResponseEntity
            .ok(
                serviceProvides.map { ServiceProviderResponse.fromEntity(it) }
            )
    }

    fun findAllCategories(): ResponseEntity<List<CategoriesResponse>> {
        val serviceProviderCategories = serviceProviderCategoryRepository.findAll()

        return ResponseEntity
            .ok(
                serviceProviderCategories.map { CategoriesResponse.fromEntity(it) }
            )
    }

}