package io.traqueno.user.entity.request

class LoginRequest(
    val email: String,
    val password: String
)

class RegisterRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)