package io.traqueno.user.entity.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("user-entity")
data class User(
    @Id
    val id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var hashedPassword: String
)