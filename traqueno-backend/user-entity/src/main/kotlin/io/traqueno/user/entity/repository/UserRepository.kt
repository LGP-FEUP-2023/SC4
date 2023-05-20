package io.traqueno.user.entity.repository

import io.traqueno.user.entity.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findByEmail(email: String): User?
    fun existsByEmail(email: String): Boolean
}