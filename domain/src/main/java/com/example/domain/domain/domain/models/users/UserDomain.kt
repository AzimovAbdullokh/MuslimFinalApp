package com.example.domain.domain.domain.models.users

import java.util.*

//
//class UserDomain(
//    val objectId: String,
//    var email: String,
//    var lastName: String,
//    var firstName: String,
//    var age: String,
//    var createAt: Date,
//    var image: UserImageDomain = UserImageDomain.unknown(),
//    var password: String? = null,
//    var sessionToken: String,
//)

data class UserDomain(
    val objectId: String,
    var userLogin: String,
    var userPassword: String? = null,
    var lastName: String,
    var firstName: String,
    var userEmail: String,
    var age: String,
    var userType: String,
    var image: UserImageDomain = UserImageDomain.unknown(),
    var sessionToken: String
) {
    companion object {
        fun unknown() = UserDomain(
            objectId = UUID.randomUUID().toString(),
            userLogin = String(),
            image = UserImageDomain(String(), String(), String()),
            userPassword = String(),
            lastName = String(),
            firstName = String(),
            userEmail = String(),
            sessionToken = String(),
            age = String(),
            userType = String(),
        )
    }
}

