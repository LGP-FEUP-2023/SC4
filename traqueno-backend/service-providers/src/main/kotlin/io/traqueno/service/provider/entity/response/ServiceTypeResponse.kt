package io.traqueno.service.provider.entity.response

import io.traqueno.service.provider.entity.model.ServiceType

class ServiceTypeResponse(
    val id: String,
    val name: String,
    val duration: String,
    var price: Double,
    var currency: String
) {
    companion object {
        fun fromEntity(serviceType: ServiceType): ServiceTypeResponse =
            ServiceTypeResponse(
                id = "serviceType.id",
                name = serviceType.name,
                duration = serviceType.duration,
                price = serviceType.price,
                currency = serviceType.currency
            )
    }
}