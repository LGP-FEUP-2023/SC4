package io.traqueno.service.provider.entity.model

import java.time.Duration
import java.util.*

data class Service(
    val id: String,
    val serviceProviderId: String,
    val name: String,
    val description: String,
    val duration: Duration,
    var price: Double,
    var currency: String
)