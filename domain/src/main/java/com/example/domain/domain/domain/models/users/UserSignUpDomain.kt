package com.example.domain.domain.domain.models.users

data class UserSignUpDomain(
    var userLogin: String,
    var userPassword: String,
    var lastName: String,
    var firstName: String,
    var userEmail: String,
    var userType: String,
    var age: String,
    var sessionToken: String?
)