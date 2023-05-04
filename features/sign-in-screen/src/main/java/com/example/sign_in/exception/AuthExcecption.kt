package com.example.sign_in.exception

abstract class AuthExcecption(
    val errorMessage: String = String(),
    val throwable: Throwable? = null,
) : Exception()

class ValidateError(message: String) : AuthExcecption(errorMessage = message)