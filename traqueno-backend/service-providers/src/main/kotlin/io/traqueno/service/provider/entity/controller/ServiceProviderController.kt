package io.traqueno.service.provider.entity.controller

import io.traqueno.service.provider.entity.exception.ApiException
import io.traqueno.service.provider.entity.model.ServiceProvider
import io.traqueno.service.provider.entity.request.ServiceProviderRequest
import io.traqueno.service.provider.entity.response.CategoriesResponse
import io.traqueno.service.provider.entity.response.ServiceProviderResponse
import io.traqueno.service.provider.entity.service.ServiceProviderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/service-provider-entity")
class ServiceProviderController(
    private val serviceProviderService: ServiceProviderService
) {
    @PostMapping("/v1/serviceprovider/register")
    fun register(@RequestBody payload: ServiceProviderRequest): ResponseEntity<ServiceProviderResponse> {
        if (serviceProviderService.existByName(payload.name)) {
            throw ApiException(400, "Service provider name: '${payload.name}' as already been registered")
        }

        val serviceProvider = ServiceProviderRequest(
            name = payload.name,
            description = payload.description,
            contact = payload.contact,
            openingHours = payload.openingHours,
            categoryId = payload.categoryId,
            location = payload.location,
        )

        val savedServiceProvider = serviceProviderService.createServiceProvider(serviceProvider);

        return ResponseEntity
            .ok(
                ServiceProviderResponse.fromEntity(savedServiceProvider)
            )
    }

    @GetMapping("/v1/serviceprovider/all")
    fun findAllServiceProviders(): ResponseEntity<List<ServiceProviderResponse>> {
        return serviceProviderService.findAllServiceProviders();
    }


    @GetMapping("/v1/serviceprovider/{id}")
    fun getServiceProvider(@PathVariable("id") id: String): ResponseEntity<ServiceProvider> {
        val serviceProvider = serviceProviderService.findById(id)
        return if (serviceProvider != null) ResponseEntity.ok(serviceProvider) else ResponseEntity
            .notFound().build()
    }

    @GetMapping("/v1/serviceprovider/category/{category}")
    fun findAllServiceProvidersByCategory(@PathVariable("category") category: String): ResponseEntity<List<ServiceProviderResponse>> {
        return serviceProviderService.findAllByCategoryEquals(category);
    }

}