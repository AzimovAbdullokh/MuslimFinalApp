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
    @SerializedName("NamazImage") val namazImage: NamazPosterCloud,
)

data class NamazPosterCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String,
    @SerializedName("url") var url: String,
)