package io.traqueno.service.provider.entity.request

import io.traqueno.service.provider.entity.model.ServiceType

class ServiceRequest(
    val name: String,
    val servicesType: List<ServiceType>
)

