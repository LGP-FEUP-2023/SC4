package io.traqueno.service.provider.entity.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("service-provider-entity")
data class ServiceProvider(
    @Id
    val id: String,
    val name: String,
    var category: ServiceProviderCategory,
    var contact: Contact,
    var location: Location,
    var openingHours: OpeningHours,
    var description: String
)
data class OpeningHours(
    val monday: Array<Interval>?,
    val tuesday: Array<Interval>?,
    val wednesday: Array<Interval>?,
    val thursday: Array<Interval>?,
    val friday: Array<Interval>?,
    val saturday: Array<Interval>?,
    val sunday: Array<Interval>?,
    val holiday: Array<Interval>?
)

data class Interval(
    val from: Date,
    val until: Date
)