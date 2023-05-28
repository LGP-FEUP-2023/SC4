package io.traqueno.service.provider.entity.response

import io.traqueno.service.provider.entity.model.Service

class ServiceResponse(
    val id: String,
    val name: String
) {
    companion object {
        fun fromEntity(service: Service): ServiceResponse =
            ServiceResponse(
                id = service.id,
                name = service.name
            )
    }
}