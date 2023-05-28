package io.traqueno.service.provider.entity.response

import io.traqueno.service.provider.entity.model.Employee

class EmployeeResponse(
    val id: String,
    val name: String,
    val imgUrl: String
) {
    companion object {
        fun fromEntity(employee: Employee): EmployeeResponse =
            EmployeeResponse(
                id = employee.id,
                name = employee.name,
                imgUrl = employee.imgUrl
            )
    }
}