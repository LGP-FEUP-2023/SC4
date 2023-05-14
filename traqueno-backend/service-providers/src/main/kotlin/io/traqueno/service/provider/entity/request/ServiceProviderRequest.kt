package io.traqueno.service.provider.entity.request

import io.traqueno.service.provider.entity.model.Contact
import io.traqueno.service.provider.entity.model.Location
import io.traqueno.service.provider.entity.model.OpeningHours
import io.traqueno.service.provider.entity.model.ServiceCategory

class ServiceProviderRequest(
    val name: String,
    val category: ServiceCategory,
    val contact: Contact,
    var location: Location,
    var openingHours: OpeningHours,
    val description: String
)
