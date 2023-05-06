package io.traqueno.service.providers.core.model

import java.util.*

data class ServiceProvider(
    val id: UUID,
    val name: String,
    var category: ServiceCategory,
    var contact: Contact,
    var location: Location,
    var openingHours: OpeningHours,
    var description: String
)
enum class ServiceCategory{
    HOME,
    CAR,
    HEALTH,
    BEAUTY
}
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