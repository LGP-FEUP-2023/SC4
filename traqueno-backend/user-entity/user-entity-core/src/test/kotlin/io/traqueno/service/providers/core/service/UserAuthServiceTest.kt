package io.traqueno.service.providers.core.service

import io.traqueno.user.entity.core.external.IUserAuthDatabase
import io.traqueno.user.entity.core.model.User
import io.traqueno.user.entity.core.security.JwtUtils
import io.traqueno.user.entity.core.security.PasswordUtils
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.quarkus.security.ForbiddenException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

@Nested
internal class UserAuthServiceTest {
    private val userAuthDatabase: IUserAuthDatabase = mockk()
    private val passwordUtils: PasswordUtils = mockk()
    private val jwtUtils: JwtUtils = mockk()

    private val userAuthService = UserAuthService(userAuthDatabase, passwordUtils, jwtUtils)

    @Test
    fun `on missing email, returns invalid user`() {
        //arrange
        val email = "email"
        val password = "secret"

        every {
            userAuthDatabase.getUserByEmail(email)
        } returns null

        //act
        val ex = assertThrows<ForbiddenException> {
            userAuthService.login(email, password)
        }

        //assert
        assertThat(ex.message).isEqualTo("Invalid email")

        verify {
            userAuthDatabase.getUserByEmail(email)
        }
    }

    @Test
    fun `on valid email but invalid password, returns invalid password`() {
        //arrange
        val email = "email"
        val firstName = "Fisrt Name"
        val lastName = "Last Name"
        val uuid = UUID.randomUUID()
        val password = "secret"
        val hashpassword = "otherPassword"

        every {
            userAuthDatabase.getUserByEmail(email)
        } returns User(uuid, firstName, lastName, email, hashpassword)

        every {
            passwordUtils.validatePassword(password, hashpassword)
        } returns false

        //act
        val ex = assertThrows<ForbiddenException> {
            userAuthService.login(email, password)
        }


        //assert
        assertThat(ex.message).isEqualTo("Invalid password")

        verify {
            userAuthDatabase.getUserByEmail(email)
        }
    }

    @Test
    fun `on valid email and valid password, returns login success`() {
        //arrange
        val email = "email"
        val password = "secret"
        val firstName = "First Name"
        val lastName = "Last Name"
        val uuid = UUID.randomUUID()
        val user = User(uuid, firstName, lastName, email, password)
        val jwt = "jwt"

        every {
            userAuthDatabase.getUserByEmail(email)
        } returns user

        every {
            passwordUtils.validatePassword(password, password)
        } returns true

        every {
            jwtUtils.createJwt(user)
        } returns jwt

        //act
        val actual = userAuthService.login(email, password)

        //assert
        assertThat(actual).isEqualTo(jwt)

        verify {
            userAuthDatabase.getUserByEmail(email)
        }
    }
}