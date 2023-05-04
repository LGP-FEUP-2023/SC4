package io.traqueno.service.providers.entity.core.model

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
    DENTIST
    HAIRDRESSER,
}
data class OpeningHours(
    val monday: Interval[]?,
    val tuesday: Interval[]?,
    val wednesday: Interval[]?,
    val thursday: Interval[]?,
    val friday: Interval[]?,
    val saturday: Interval[]?,
    val sunday: Interval[]?,
    val holiday: Interval[]?
)

data class Interval{
    val from: DateTime,
    val until: DateTime
}