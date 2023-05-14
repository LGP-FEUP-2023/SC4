package io.traqueno.user.entity.response

data class LoginResponse(
    val token: String
)

data class GetUserResponse(
    val firstName: String,
    val lastName: String,
    val email: String,
    val userId: String
)