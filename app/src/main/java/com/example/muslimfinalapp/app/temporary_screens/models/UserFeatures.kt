package com.example.muslimfinalapp.app.temporary_screens.models

import java.util.*

data class UserFeatures (
    var objectId: String,
    var userLogin: String,
    var userPassword: String? = null,
    var lastName: String,
    var firstName: String,
    var userEmail: String,
    var image: UserFeaturesImage? = null,
    var sessionToken: String,
    var age: String,
) {


    companion object {
        fun unknown() = UserFeatures(
            objectId = UUID.randomUUID().toString(),
            userLogin = String(),
            userPassword = String(),
            image = UserFeaturesImage(String(), String(), String()),
            lastName = String(),
            firstName = String(),
            userEmail = String(),
            sessionToken = String(),
            age = String(),
        )
    }
}

data class UserFeaturesImage(
    var name: String,
    var type: String,
    var url: String,
)