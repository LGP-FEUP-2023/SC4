package io.traqueno.service.provider.entity.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("service-provider-category-entity")
data class ServiceProviderCategory(
    @Id
    val id: String,
    val name: String,
    val imgUrl: String
)
