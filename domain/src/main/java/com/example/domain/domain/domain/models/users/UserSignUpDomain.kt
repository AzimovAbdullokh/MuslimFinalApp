package com.example.domain.domain.domain.models.users

data class UserSignUpDomain(
    var username:String,
    var email: String,
    var password: String,
    var lastName: String,
    var age: String,
    var userSessionToken: String,
)