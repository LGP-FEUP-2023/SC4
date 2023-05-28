package io.traqueno.service.provider.entity.response

import io.traqueno.service.provider.entity.model.*

class ServiceProviderResponse(
    val id: String,
    val companyName: String,
    val category: ServiceProviderCategory?,
    val contact: Contact,
    var location: Location,
    var openingHours: OpeningHours,
    val description: String,
    val services: List<Service>,
    val employees: List<Employee>
) {
    companion object {
        fun fromEntity(serviceProvider: ServiceProvider): ServiceProviderResponse =
            ServiceProviderResponse(
                id = serviceProvider.id,
                companyName = serviceProvider.name,
                category = serviceProvider.category,
                contact = serviceProvider.contact,
                location = serviceProvider.location,
                openingHours = serviceProvider.openingHours,
                description = serviceProvider.description,
                services = serviceProvider.services,
                employees = serviceProvider.employee
            )
    }
}

class CategoriesResponse(
    val id: String,
    val name: String,
    val imgUrl: String
) {
    companion object {
        fun fromEntity(serviceProviderCategory: ServiceProviderCategory): CategoriesResponse =
            CategoriesResponse(
                id = serviceProviderCategory.id,
                name = serviceProviderCategory.name,
                imgUrl = serviceProviderCategory.imgUrl
            )
    }
}