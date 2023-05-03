package io.traqueno.user.entity.core

import io.traqueno.user.entity.core.security.PasswordUtils
import de.mkammerer.argon2.Argon2Factory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PasswordUtilsTest {

    private val argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id)

    private val passwordUtils = PasswordUtils(argon2)

    @Test
    fun getPasswordHashTest() {
        val password = "password"

        val actual = passwordUtils.getPasswordHash(password)

        assertThat(actual).isNotNull
                .isNotEmpty
                .isNotEqualTo(password)
    }

    @Test
    fun getValidatePasswordReturnsTrueTest() {
        val password = "password"

        val passwordHash = passwordUtils.getPasswordHash(password)
        val actual = passwordUtils.validatePassword(password, passwordHash)

        assertThat(actual).isTrue
    }

    @Test
    fun getValidatePasswordReturnsFalseTest() {
        val password = "password"

        val passwordHash = passwordUtils.getPasswordHash(password)
        val actual = passwordUtils.validatePassword("otherPassword", passwordHash)

        assertThat(actual).isFalse
    }
}