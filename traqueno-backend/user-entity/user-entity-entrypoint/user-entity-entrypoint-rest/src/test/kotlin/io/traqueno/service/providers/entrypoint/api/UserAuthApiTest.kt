package io.traqueno.service.providers.entrypoint.api

import io.traqueno.service.providers.core.service.UserAuthService
import io.traqueno.service.providers.entrypoint.api.model.LoginRequest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


@Nested
internal class UserAuthApiTest {
    private val userAuthService: UserAuthService = mockk()

    private val userAuthApi = UserAuthApi(userAuthService)

    @Test
    fun `on valid login request , userAuthService login gets called`() {
        //arrange
        val email = "email"
        val password = "secret"
        val jwt = "jwt"

        every {
            userAuthService.login(email, password)
        } returns jwt

        //act
        val actual = userAuthApi.login(LoginRequest(email, password))

        //assert
        assertThat(actual.jwt).isEqualTo(jwt)

        verify {
            userAuthService.login(email, password)
        }
    }
}