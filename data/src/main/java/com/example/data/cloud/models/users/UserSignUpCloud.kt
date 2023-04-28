package com.example.data.cloud.models.users

import com.google.gson.annotations.SerializedName

data class UserSignUpCloud(
    @SerializedName("username") var username: String,
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
    @SerializedName("lastName") var lastName: String,
    @SerializedName("age") var age: String,
    @SerializedName("userSessionToken") var userSessionToken: String,
)