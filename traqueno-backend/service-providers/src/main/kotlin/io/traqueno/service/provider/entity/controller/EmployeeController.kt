package io.traqueno.service.provider.entity.controller

import io.traqueno.service.provider.entity.request.EmployeeRequest
import io.traqueno.service.provider.entity.response.CategoriesResponse
import io.traqueno.service.provider.entity.response.EmployeeResponse
import io.traqueno.service.provider.entity.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employee-entity")
class EmployeeController(
    private val employeeService: EmployeeService
) {
    @PostMapping("/v1/employee/register")
    fun createCompany(@RequestBody request: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val createdEmployee = employeeService.createEmployee(request)

        return ResponseEntity
            .ok(
                EmployeeResponse.fromEntity(createdEmployee)
            )
    }

    @GetMapping("/v1/employee/all")
    fun findAllEmployees(): ResponseEntity<List<EmployeeResponse>> {
        val employees = employeeService.findAll()

        return ResponseEntity
            .ok(
                employees.map { EmployeeResponse.fromEntity(it) }
            )
    }
}