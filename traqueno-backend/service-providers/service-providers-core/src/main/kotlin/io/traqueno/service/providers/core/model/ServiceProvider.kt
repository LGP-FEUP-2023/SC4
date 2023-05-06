package io.traqueno.service.providers.core.model

import java.util.*

data class ServiceProvider(
    val id: UUID,
    var domain: ServiceDomain,
    var topic: ServiceTopic,
    var contact: Contact,
    var openingHours: OpeningHours
)
enum class ServiceDomain{
    HOME,
    CAR,
    HEALTH,
    BEAUTY
}

enum class ServiceTopic{
    PLUMBER,
    CAR_MECHANIC,
    DENTIST,
    HAIRDRESSER
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