package io.traqueno.user.entity.entrypoint.api.auth.model

data class LoginResponse(
    val jwt: String
)

data class GetUserResponse(
    val firstName: String,
    val lastName: String,
    val email: String,
    val userId: String
)