package io.traqueno.user.entity.service

import io.traqueno.user.entity.exception.NotFoundException
import io.traqueno.user.entity.model.User
import io.traqueno.user.entity.repository.UserRepository
import io.traqueno.user.entity.request.RegisterRequest
import io.traqueno.user.entity.response.GetUserResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(request: RegisterRequest): User =
        userRepository.save(
            User(
                id = UUID.randomUUID().toString(),
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email,
                hashedPassword = request.password
            )
        )

    fun findById(id: String): User =
        userRepository.findById(id).orElseThrow { NotFoundException("User with id $id not found") }

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email);
    }

    fun existByEmail(email: String): Boolean {
        return userRepository.existsByEmail(email);
    }

    fun findAllUsers(): ResponseEntity<List<GetUserResponse>> {
        val users = userRepository.findAll()
        return ResponseEntity
            .ok(
                users.map { GetUserResponse.fromEntity(it) }
            )
    }

}