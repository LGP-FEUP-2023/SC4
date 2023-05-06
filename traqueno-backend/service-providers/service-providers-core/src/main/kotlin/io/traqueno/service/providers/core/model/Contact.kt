package io.traqueno.service.providers.core.model

import java.net.URL
import java.util.*

data class Contact(
    val webPageURL: String?,
    var telephone: String?,
    var mobile: String?,
    var socialNetworks: Array<SocialNetwork>
)

data class SocialNetwork(
    val socialNetwork: SocialNetworkType,
    val url: String
)

enum class SocialNetworkType{
    FACEBOOK,
    INSTAGRAM,
    TWITTER
}
