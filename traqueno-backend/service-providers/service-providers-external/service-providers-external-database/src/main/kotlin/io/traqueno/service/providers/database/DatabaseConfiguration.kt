package io.traqueno.service.providers.database

import com.mongodb.client.MongoCollection
import io.traqueno.service.providers.core.model.ServiceProvider
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
    ): MongoCollection<ServiceProvider> {
        return KMongo
            .createClient(mongoDatabaseUrl)
            .getDatabase(mongoDatabaseName)
            .getCollection<ServiceProvider>(mongoDatabaseCollectionName)
    }
}