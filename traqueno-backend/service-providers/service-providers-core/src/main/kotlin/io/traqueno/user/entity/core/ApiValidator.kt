package io.traqueno.user.entity.core

/**
 * This class has the messages and values used in the API validations.
 *
 */
object ApiValidator {
    //Further API validation values
    /**
     * Valid user.
     */
    const val VALID_USER = "DummyUser"

    /**
     * Valid password.
     */
    const val VALID_PASSWORD = "DummyPassword"

    /**
     * Login success message.
     */
    const val LOGIN_SUCCESS = "jwt"

    /**
     * Invalid user message.
     */
    const val INVALID_USER = "User does not exit, please register"

    /**
     * Invalid password message.
     */
    const val INVALID_PASSWORD = "Password is invalid"
}