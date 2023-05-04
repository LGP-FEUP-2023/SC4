package io.traqueno.service.providers.database.entity

import com.mongodb.client.MongoCollection
import io.traqueno.service.providers.entity.core.external.IServiceProvidersDatabase
import io.traqueno.service.providers.entity.core.model.ServiceProvider
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ServiceProvidersDatabase(private val serviceProvidersCollection: MongoCollection<ServiceProvider>) : IServiceProvidersDatabase, android.os.Parcelable {
      
    override fun getServiceProviderById(id: UUID): = serviceProvidersCollection.findOne(ServiceProvider::id eq id)

    override fun searchServiceProvidersWithNameLike(name: String): ServiceProvider?{
        val results = runCatching {
            serviceProvidersCollection.find()
        }
    }
    
    override fun putServiceProvider(serviceProvider: ServiceProvider): Boolean{
        val result = runCatching {
            serviceProvider.let(serviceProvidersCollection::insertOne).wasAcknowledged()
        }
        return result.getOrNull() ?: false
    }

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<ServiceProvidersDatabase> {
        override fun createFromParcel(parcel: android.os.Parcel): ServiceProvidersDatabase {
            return ServiceProvidersDatabase(parcel)
        }

        override fun newArray(size: Int): Array<ServiceProvidersDatabase?> {
            return arrayOfNulls(size)
        }
    }
}