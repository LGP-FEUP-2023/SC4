package io.traqueno.service.provider.entity.controller

import io.traqueno.service.provider.entity.request.ServiceTypeRequest
import io.traqueno.service.provider.entity.response.ServiceTypeResponse
import io.traqueno.service.provider.entity.service.ServiceTypeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/servicetype-entity")
class ServiceTypeController(
    private val serviceTypeService: ServiceTypeService
) {
    @PostMapping("/v1/servicetype/register")
    fun createCompany(@RequestBody request: ServiceTypeRequest): ResponseEntity<ServiceTypeResponse> {
        val createdEmployee = serviceTypeService.createServiceType(request)

        return ResponseEntity
            .ok(
                ServiceTypeResponse.fromEntity(createdEmployee)
            )
    }

    @GetMapping("/v1/servicetype/all")
    fun findAllServicesType(): ResponseEntity<List<ServiceTypeResponse>> {
        val servicesType = serviceTypeService.findAll()

        return ResponseEntity
            .ok(
                servicesType.map { ServiceTypeResponse.fromEntity(it) }
            )
    }
}