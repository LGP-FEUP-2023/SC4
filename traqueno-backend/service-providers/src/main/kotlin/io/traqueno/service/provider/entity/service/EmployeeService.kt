package io.traqueno.service.provider.entity.service

import io.traqueno.service.provider.entity.exception.NotFoundException
import io.traqueno.service.provider.entity.model.Employee
import io.traqueno.service.provider.entity.repository.EmployeeRepository
import io.traqueno.service.provider.entity.request.EmployeeRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {
    fun createEmployee(request: EmployeeRequest): Employee =
        employeeRepository.save(
            Employee(
                id = UUID.randomUUID().toString(),
                name = request.name,
                imgUrl = request.imgUrl
            )
        )

    fun findAll(): List<Employee> =
        employeeRepository.findAll()

    fun findById(id: String): Employee =
        employeeRepository.findById(id)
            .orElseThrow { NotFoundException("Employee with id $id not found") }
}