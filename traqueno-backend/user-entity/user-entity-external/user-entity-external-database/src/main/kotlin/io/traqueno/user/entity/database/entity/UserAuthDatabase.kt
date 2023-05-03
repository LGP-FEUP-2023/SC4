package io.traqueno.user.entity.database.entity

import com.mongodb.client.MongoCollection
import io.traqueno.user.entity.core.external.IUserAuthDatabase
import io.traqueno.user.entity.core.model.User
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserAuthDatabase(private val userCollection: MongoCollection<UserDBO>) : IUserAuthDatabase {

    override fun getUserByEmail(email: String) = userCollection.findOne(UserDBO::email eq email)?.toUser()

    override fun getUserById(userId: String) = userCollection.findOne(UserDBO::userId eq userId)?.toUser()

    override fun putUser(newUser: User): Boolean {
        val result = runCatching {
            newUser.toUserDBO().let(userCollection::insertOne).wasAcknowledged()
        }
        return result.getOrNull() ?: false
    }
}

fun UserDBO.toUser() =
    User(UUID.fromString(this.userId), this.firstName, this.lastName, this.email, this.hashedPassword)

fun User.toUserDBO() = UserDBO(this.userId.toString(), this.firstName, this.lastName, this.email, this.hashedPassword)