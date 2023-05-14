package io.traqueno.user.entity.controller

import io.traqueno.user.entity.exception.ApiException
import io.traqueno.user.entity.request.LoginRequest
import io.traqueno.user.entity.request.RegisterRequest
import io.traqueno.user.entity.response.LoginResponse
import io.traqueno.user.entity.service.HashService
import io.traqueno.user.entity.service.TokenService
import io.traqueno.user.entity.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * This controller handles login and register requests.
 * Both routes are public as specified in SecurityConfig.
 */
@RestController
@RequestMapping("/api/user-entity")
class UserController(
    private val hashService: HashService,
    private val tokenService: TokenService,
    private val userService: UserService,
) {
    @PostMapping("/v1/user/login")
    fun login(@RequestBody payload: LoginRequest): LoginResponse {
        val user = userService.findByEmail(payload.email) ?: throw ApiException(400, "Login failed")

        if (!hashService.checkBcrypt(payload.password, user.hashedPassword)) {
            throw ApiException(400, "Login failed")
        }

        return LoginResponse(
            token = tokenService.createToken(user),
        )
    }

    @PostMapping("/v1/user/register")
    fun register(@RequestBody payload: RegisterRequest): LoginResponse {
        if (userService.existByEmail(payload.email)) {
            throw ApiException(400, "Email '${payload.email}' as already been registered")
        }

        val user = RegisterRequest(
            firstName = payload.firstName,
            lastName = payload.lastName,
            email = payload.email,
            password = hashService.hashBcrypt(payload.password),
        )

        val savedUser = userService.createUser(user);

        return LoginResponse(
            token = tokenService.createToken(savedUser),
        )
    }
}