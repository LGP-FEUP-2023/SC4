package io.traqueno.service.providers.core.model

import java.time.Duration
import java.util.*

data class Service(
    val id: UUID,
    val serviceProviderId: UUID,
    val name: String,
    val description: String,
    val duration: Duration,
    var price: Double,
    var currency: String
)