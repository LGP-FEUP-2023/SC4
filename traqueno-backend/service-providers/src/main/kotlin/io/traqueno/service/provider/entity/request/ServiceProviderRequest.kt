package io.traqueno.service.provider.entity.request

import io.traqueno.service.provider.entity.model.*

class ServiceProviderRequest(
    val name: String,
    val categoryId: String,
    val contact: Contact,
    var location: Location,
    var openingHours: OpeningHours,
    val description: String,
    val services: List<Service>,
    val employees: List<Employee>
)
