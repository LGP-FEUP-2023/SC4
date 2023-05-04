package io.traqueno.user.entity.core.security

import io.traqueno.user.entity.core.model.User
import io.smallrye.jwt.build.Jwt
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.jwt.Claims
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class JwtUtils(@ConfigProperty(name = "quarkus.jwt.secret") private val privateSignKey: String) {
    fun createJwt(user: User): String = Jwt.issuer("https://example.com/issuer")
        .upn(user.userId.toString())
        .claim(Claims.email, user.email)
        .signWithSecret(privateSignKey)
}