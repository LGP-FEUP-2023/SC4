package io.traqueno.user.entity.database.entity

data class UserDBO(
    val userId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val hashedPassword: String
)