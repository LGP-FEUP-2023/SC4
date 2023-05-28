package io.traqueno.service.provider.entity.request

import java.time.Duration

class ServiceTypeRequest (
    val name: String,
    val duration: String,
    var price: Double,
    var currency: String
)