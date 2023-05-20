package io.traqueno.user.entity.response

import io.traqueno.user.entity.model.User

data class LoginResponse(
    val token: String
)

data class GetUserResponse(
    val firstName: String,
    val lastName: String,
    val email: String,
    val userId: String
){
    companion object{
        fun fromEntity(user: User): GetUserResponse =
            GetUserResponse(

                firstName = user.firstName,
                lastName = user.lastName,
                email = user.email,
                userId = user.id
            )
    }

}