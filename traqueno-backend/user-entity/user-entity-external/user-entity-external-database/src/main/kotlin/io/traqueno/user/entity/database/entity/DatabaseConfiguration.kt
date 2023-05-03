package io.traqueno.user.entity.database.entity

import com.mongodb.client.MongoCollection
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class DatabaseConfiguration {

    @Produces
    fun mongoCollection(
        @ConfigProperty(name = "mongo.database.url") mongoDatabaseUrl: String,
        @ConfigProperty(name = "mongo.database.name") mongoDatabaseName: String,
        @ConfigProperty(name = "mongo.database.collection.name") mongoDatabaseCollectionName: String
    ): MongoCollection<UserDBO> {
        return KMongo
            .createClient(mongoDatabaseUrl)
            .getDatabase(mongoDatabaseName)
            .getCollection<UserDBO>(mongoDatabaseCollectionName)
    }
}