package io.traqueno.service.provider.entity.request

import io.traqueno.service.provider.entity.model.Contact
import io.traqueno.service.provider.entity.model.Location
import io.traqueno.service.provider.entity.model.OpeningHours
import io.traqueno.service.provider.entity.model.ServiceProviderCategory

class ServiceProviderRequest(
    val name: String,
    val category: ServiceProviderCategory,
    val contact: Contact,
    var location: Location,
    var openingHours: OpeningHours,
    val description: String
)
