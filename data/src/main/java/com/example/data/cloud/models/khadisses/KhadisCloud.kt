package com.example.data.cloud.models.khadisses

import com.google.gson.annotations.SerializedName
import java.util.*

data class KhadisCloud(
    @SerializedName("objectId") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("createdAt") val createdAt: Date,
    @SerializedName("khadisId") val khadisId: String,
    @SerializedName("description") val khadisDescription: String,
    @SerializedName("theme") val khadisSubject: String,
)