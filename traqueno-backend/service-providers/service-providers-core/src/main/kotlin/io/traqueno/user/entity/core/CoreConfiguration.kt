package io.traqueno.user.entity.core

import de.mkammerer.argon2.Argon2
import de.mkammerer.argon2.Argon2Factory
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class CoreConfiguration {

    @Produces
    fun argon2(): Argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id)
}
