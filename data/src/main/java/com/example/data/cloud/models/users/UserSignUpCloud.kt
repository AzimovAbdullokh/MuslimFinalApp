package com.example.data.cloud.models.users

import com.google.gson.annotations.SerializedName

data class UserSignUpCloud(
    @SerializedName("username") var userLogin: String,
    @SerializedName("password") var userPassword: String,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("email") var userEmail: String,
    @SerializedName("age") var age: String,
    @SerializedName("userType") var userType: String,
    @SerializedName("sessionToken") var sessionToken: String?
)