package com.example.data.cloud.models.nasheeds

import com.google.gson.annotations.SerializedName
import java.util.Date

data class NasheedsCloud(
    @SerializedName("objectId") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("createdAt") val createdAt: Date,
    @SerializedName("audioId") val audioId: String,
    @SerializedName("audio") val nasheedFile: NasheedFileCloud,
    @SerializedName("image") val nasheedPoster: NasheedPosterCloud,
)

data class NasheedFileCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String = "File",
    @SerializedName("url") var url: String,

    )

data class NasheedPosterCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String,
    @SerializedName("url") var url: String,
)