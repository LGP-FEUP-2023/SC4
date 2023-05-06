package io.traqueno.service.providers.core.model

data class Location(
    val streetName: String,
    val city: String,
    val country: String,
    var longitude: Double,
    var latitude: Double
)