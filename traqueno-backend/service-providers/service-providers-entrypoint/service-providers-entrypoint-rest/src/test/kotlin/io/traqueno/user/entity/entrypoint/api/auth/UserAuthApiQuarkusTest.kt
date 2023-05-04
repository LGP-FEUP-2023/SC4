package io.traqueno.user.entity.entrypoint.api.auth


import io.traqueno.user.entity.core.service.UserAuthService
import io.traqueno.user.entity.entrypoint.api.auth.model.LoginRequest
import io.traqueno.user.entity.entrypoint.api.auth.model.RegisterRequest
import io.mockk.every
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusMock
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


@QuarkusTest
class UserAuthApiQuarkusTest {
    companion object {
        private const val ROOT_PATH = "/api/user-entity"
    }

    private val userAuthService = mockk<UserAuthService>()

    @BeforeEach
    fun setup() {
        QuarkusMock.installMockForType(userAuthService, UserAuthService::class.java)
    }

    @Test
    fun testLoginPOSTSuccess() {
        val userEmail = "some@email.com"
        val password = "secret"

        every {
            userAuthService.login(userEmail, password)
        } returns "jwt1"

        given()
            .with().body(LoginRequest(userEmail, password))
            .with().header("Content-Type", "application/json")
            .`when`().post("$ROOT_PATH/v1/user/login")
            .then()
            .statusCode(200)
            .body(CoreMatchers.`is`("{\"jwt\":\"jwt1\"}"))
    }

    @Test
    fun testRegisterPOSTSuccess() {
        val userEmail = "some@email.com"
        val password = "secret"
        val firstName = "First Name"
        val lastName = "Last Name"

        every {
            userAuthService.register(firstName, lastName, userEmail, password)
        } returns Unit

        given()
            .with().body(RegisterRequest(firstName, lastName, userEmail, password))
            .with().header("Content-Type", "application/json")
            .`when`().post("$ROOT_PATH/v1/user/register")
            .then()
            .statusCode(204)
    }
}
