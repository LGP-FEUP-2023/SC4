package io.traqueno.service.providers.database.entity

data class ServiceProviderDBO(
    val id: UUID,
    var domain: String,
    var topic: String,
    var contact: Contact,
    var openingHours: OpeningHours
)