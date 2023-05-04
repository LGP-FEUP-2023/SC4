package io.traqueno.user.entity.database.entity

data class ServiceProviderDBO(
    val id: UUID,
    var domain: String,
    var topic: String,
    var contact: Contact,
    var openingHours: OpeningHours
)