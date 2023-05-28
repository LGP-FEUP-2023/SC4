package io.traqueno.service.provider.entity.repository

import io.traqueno.service.provider.entity.model.Employee
import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeRepository : MongoRepository<Employee, String> {
}