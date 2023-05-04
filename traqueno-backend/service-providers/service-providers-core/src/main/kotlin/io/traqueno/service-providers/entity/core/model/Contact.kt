package io.traqueno.service.providers.entity.core.model

import java.util.*

data class Contact(
    val webPageURL: String?,
    var telephone: String?,
    var mobile: String?,
    var socialNetworks: SocialNetwork[]
)

data class SocialNetwork(
    val socialNetwork: SocialNetworkType,
    val URL: String
)

enum class SocialNetworkType{
    FACEBOOK,
    INSTAGRAM,
    TWITTER
}
