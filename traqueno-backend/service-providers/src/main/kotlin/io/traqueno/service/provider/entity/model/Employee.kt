package io.traqueno.service.provider.entity.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("employee-entity")
data class Employee(
    @Id
    var id: String,
    var name: String,
    var imgUrl: String
)