package io.traqueno.service.provider.entity.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("service-provider-services-entity")
data class Service(
    @Id
    val id: String,
    val name: String,
    val serviceType: List<ServiceType>
)

data class ServiceType(
    val name: String,
    val duration: String,
    var price: Double,
    var currency: String
)
