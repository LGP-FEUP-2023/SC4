package io.traqueno.service.providers.database

import com.mongodb.client.MongoCollection
import io.traqueno.service.providers.core.external.IServiceProvidersDatabase
import io.traqueno.service.providers.core.model.ServiceProvider
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ServiceProvidersDatabase(private val serviceProvidersCollection: MongoCollection<ServiceProvider>) : IServiceProvidersDatabase {
      
    override fun getServiceProviderById(id: UUID): ServiceProvider? {
        return serviceProvidersCollection.findOne(ServiceProvider::id eq id);
    }

    override fun searchServiceProvidersWithNameLike(name: String): Array<ServiceProvider> {
        throw NotImplementedError();
    }
    
    override fun putServiceProvider(serviceProvider: ServiceProvider): Boolean{
        val result = runCatching {
            serviceProvider.let(serviceProvidersCollection::insertOne).wasAcknowledged()
        }
        return result.getOrNull() ?: false
    }

}