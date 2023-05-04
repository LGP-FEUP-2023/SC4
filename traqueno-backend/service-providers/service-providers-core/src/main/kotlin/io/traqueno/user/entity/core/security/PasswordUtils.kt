package io.traqueno.user.entity.core.security

import de.mkammerer.argon2.Argon2
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PasswordUtils(private val argon2: Argon2) {
    fun getPasswordHash(password: String): String {
        return argon2.hash(1, 1024 * 1024, 8, password)
    }

    fun validatePassword(password: String, hashPassword: String): Boolean {
        return argon2.verify(hashPassword, password)
    }
}