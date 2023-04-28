package com.example.data.cloud.models.users

import com.google.gson.annotations.SerializedName
import java.util.*


data class UserResponse(
    @SerializedName("results") var users: List<UserCloud>,
)

data class UserCloud(
    @SerializedName("username") var email: String,
    @SerializedName("lastName") var lastName: String,
    @SerializedName("firstName") var firstName: String,
    @SerializedName("age") var age: String,
    @SerializedName("password") var password: String,
    @SerializedName("createdAt") var createAt: Date,
    @SerializedName("objectId") var objectId: String,
    @SerializedName("image") var image: UserImageCloud,
    @SerializedName("sessionToken") var sessionToken: String?,
    @SerializedName("userSessionToken") var userSessionToken: String,
)