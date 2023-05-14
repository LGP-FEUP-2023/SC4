package io.traqueno.service.provider.entity.response

import io.traqueno.service.provider.entity.model.*

class ServiceProviderResponse(
    val id: String,
    val name: String,
    val category: ServiceCategory,
    val contact: Contact,
    var location: Location,
    var openingHours: OpeningHours,
    val description: String
) {
    companion object {
        fun fromEntity(serviceProvider: ServiceProvider): ServiceProviderResponse =
            ServiceProviderResponse(
                id = serviceProvider.id,
                name = serviceProvider.name,
                category = serviceProvider.category,
                contact = serviceProvider.contact,
                location = serviceProvider.location,
                openingHours = serviceProvider.openingHours,
                description = serviceProvider.description
            )
    }
}