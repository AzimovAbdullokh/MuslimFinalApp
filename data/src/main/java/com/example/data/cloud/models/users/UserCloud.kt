package com.example.data.cloud.models.users

import com.google.gson.annotations.SerializedName


data class UserResponse(
    @SerializedName("results") var users: List<UserCloud>,
)

data class UserCloud(
    @SerializedName("objectId") var objectId: String,
    @SerializedName("username") var userLogin: String,
    @SerializedName("password") var userPassword: String? = null,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("image") var image: UserImageCloud,
    @SerializedName("email") var userEmail: String,
    @SerializedName("userType") var userType: String,
    @SerializedName("age") var age: String,
    @SerializedName("sessionToken") var sessionToken: String
)