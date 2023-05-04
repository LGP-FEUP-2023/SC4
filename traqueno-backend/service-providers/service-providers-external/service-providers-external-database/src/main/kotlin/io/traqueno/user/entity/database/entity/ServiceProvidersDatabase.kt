package io.traqueno.user.entity.database.entity

import com.mongodb.client.MongoCollection
import io.traqueno.user.entity.core.external.IUserAuthDatabase
import io.traqueno.user.entity.core.model.User
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ServiceProvidersDatabase(private val userCollection: MongoCollection<UserDBO>) : IServiceProvidersDatabase, android.os.Parcelable {

    override fun getUserByEmail(email: String) = userCollection.findOne(UserDBO::email eq email)?.toUser()

    override fun getUserById(userId: String) = userCollection.findOne(UserDBO::userId eq userId)?.toUser()

    override fun putUser(newUser: User): Boolean {
        val result = runCatching {
            newUser.toUserDBO().let(userCollection::insertOne).wasAcknowledged()
        }
        return result.getOrNull() ?: false
    }

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<UserAuthDatabase> {
        override fun createFromParcel(parcel: android.os.Parcel): UserAuthDatabase {
            return UserAuthDatabase(parcel)
        }

        override fun newArray(size: Int): Array<UserAuthDatabase?> {
            return arrayOfNulls(size)
        }
    }
}

fun UserDBO.toUser() =
    User(UUID.fromString(this.userId), this.firstName, this.lastName, this.email, this.hashedPassword)

fun User.toUserDBO() = UserDBO(this.userId.toString(), this.firstName, this.lastName, this.email, this.hashedPassword)