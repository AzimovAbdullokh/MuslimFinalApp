package com.example.data.data.models.users

import java.util.*

data class UserSaveModel(
    var objectId: String,
    var userLogin: String,
    var userPassword: String? = null,
    var lastName: String,
    var firstName: String,
    var userEmail: String,
    var age: String,
    var userType: String,
    var image: UserSaveModelImage,
    var sessionToken: String
) {
    companion object {
        fun unknown() = UserSaveModel(
            objectId = UUID.randomUUID().toString(),
            userLogin = String(),
            image = UserSaveModelImage(String(), String(), String()),
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

data class UserSaveModelImage(
    var name: String,
    var type: String,
    var url: String,
) {
    companion object {
        fun unknown() = UserSaveModelImage(
            name = String(),
            type = String(),
            url = String(),
        )
    }
}
