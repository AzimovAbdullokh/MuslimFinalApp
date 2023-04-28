package com.example.data.cloud.models.users

import com.google.gson.annotations.SerializedName

data class UserImageCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String,
    @SerializedName("url") var url: String,
)