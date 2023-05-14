package io.traqueno.service.provider.entity.model

data class Contact(
    val webPageURL: String?,
    var telephone: String?,
    var mobile: String?,
    var socialNetworks: Array<SocialNetwork>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact

        if (webPageURL != other.webPageURL) return false
        if (telephone != other.telephone) return false
        if (mobile != other.mobile) return false
        return socialNetworks.contentEquals(other.socialNetworks)
    }

    override fun hashCode(): Int {
        var result = webPageURL?.hashCode() ?: 0
        result = 31 * result + (telephone?.hashCode() ?: 0)
        result = 31 * result + (mobile?.hashCode() ?: 0)
        result = 31 * result + socialNetworks.contentHashCode()
        return result
    }
}

data class SocialNetwork(
    val socialNetwork: SocialNetworkType,
    val url: String
)

enum class SocialNetworkType{
    FACEBOOK,
    INSTAGRAM,
    TWITTER
}
