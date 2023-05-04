package io.traqueno.user.entity.core.service

import io.traqueno.user.entity.core.external.IUserAuthDatabase
import io.traqueno.user.entity.core.model.User
import io.traqueno.user.entity.core.security.JwtUtils
import io.traqueno.user.entity.core.security.PasswordUtils
import io.quarkus.security.ForbiddenException
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserAuthService(
    private val userAuthDatabase: IUserAuthDatabase,
    private val passwordUtils: PasswordUtils,
    private val jwtUtils: JwtUtils,
) {

    fun register(firstName: String, lastName: String, email: String, password: String) {
        userAuthDatabase.getUserByEmail(email)?.let {
            throw ForbiddenException("Email '$email' as already been registered")
        }

        val passwordHash = passwordUtils.getPasswordHash(password)

        if (userAuthDatabase.putUser(User(UUID.randomUUID(),firstName, lastName, email, passwordHash)).not())
            throw RuntimeException("Failed to create user")
    }

    fun login(email: String, password: String): String {
        val user = userAuthDatabase.getUserByEmail(email) ?: throw ForbiddenException("Invalid email")

        return if (passwordUtils.validatePassword(password, user.hashedPassword))
            jwtUtils.createJwt(user)
        else throw ForbiddenException("Invalid password")
    }

    fun getUser(userId: String) =
        userAuthDatabase.getUserById(userId)

}