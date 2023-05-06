package io.traqueno.service.providers.entrypoint.api.model

data class LoginResponse(
    val jwt: String
)

data class GetUserResponse(
    val firstName: String,
    val lastName: String,
    val email: String,
    val userId: String
)