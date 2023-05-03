package io.traqueno.user.entity.core.model

import java.util.*

data class User(
    val userId: UUID,
    var firstName: String,
    var lastName: String,
    var email: String,
    var hashedPassword: String
)