package io.traqueno.user.entity.service

import io.traqueno.user.entity.model.User
import io.traqueno.user.entity.repository.UserRepository
import io.traqueno.user.entity.request.RegisterRequest
import org.springframework.data.repository.findByIdOrNull
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

    fun findById(id: String): User? {
        return userRepository.findByIdOrNull(id)
    }

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email);
    }

    fun existByEmail(email: String): Boolean {
        return userRepository.existsByEmail(email);
    }

}