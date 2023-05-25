package io.traqueno.service.provider.entity.model

data class Location (
    val streetName: String,
    val city: String,
    val country: String,
    var longitude: Double,
    var latitude: Double
)