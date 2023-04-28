package com.example.data.cloud.models.users

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserSignUpAnswerCloud(
    @SerializedName("objectId") val objectId: String,
    @SerializedName("image") val image: UserImageCloud,
    @SerializedName("sessionToken") val sessionToken: String,
    @SerializedName("createdAt") val createdAt: Date,
    )