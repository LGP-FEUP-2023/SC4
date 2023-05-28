package io.traqueno.service.provider.entity.controller

import io.traqueno.service.provider.entity.request.EmployeeRequest
import io.traqueno.service.provider.entity.request.ServiceRequest
import io.traqueno.service.provider.entity.response.CategoriesResponse
import io.traqueno.service.provider.entity.response.EmployeeResponse
import io.traqueno.service.provider.entity.response.ServiceResponse
import io.traqueno.service.provider.entity.service.EmployeeService
import io.traqueno.service.provider.entity.service.ServicesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/service-entity")
class ServiceController(
    private val servicesService: ServicesService
) {
    @PostMapping("/v1/service/register")
    fun createCompany(@RequestBody request: ServiceRequest): ResponseEntity<ServiceResponse> {
        val createdEmployee = servicesService.createService(request)

        return ResponseEntity
            .ok(
                ServiceResponse.fromEntity(createdEmployee)
            )
    }

    @GetMapping("/v1/service/all")
    fun findAllEmployees(): ResponseEntity<List<ServiceResponse>> {
        val services = servicesService.findAll()

        return ResponseEntity
            .ok(
                services.map { ServiceResponse.fromEntity(it) }
            )
    }
}