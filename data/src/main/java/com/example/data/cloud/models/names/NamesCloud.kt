package com.example.data.cloud.models.names

import com.google.gson.annotations.SerializedName

data class NamesCloud(
    @SerializedName("objectId") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: NamePosterCloud,
)


data class NamePosterCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String = "File",
    @SerializedName("url") var url: String,
)