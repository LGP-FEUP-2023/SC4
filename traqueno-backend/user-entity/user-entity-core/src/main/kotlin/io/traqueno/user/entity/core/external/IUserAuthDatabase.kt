package io.traqueno.user.entity.core.external

import io.traqueno.user.entity.core.model.User

interface IUserAuthDatabase {
    fun putUser(newUser: User): Boolean
    fun getUserByEmail(email: String): User?
    fun getUserById(userId: String): User?
}