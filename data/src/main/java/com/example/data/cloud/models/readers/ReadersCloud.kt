package com.example.data.cloud.models.readers

import com.google.gson.annotations.SerializedName

data class ReadersCloud(
    @SerializedName("objectId") val id: String,
    @SerializedName("readerId") val readerId: String,
    @SerializedName("name") val readerName: String,
    @SerializedName("poster") val readerPoster: ReaderPosterCloud,
)

data class ReaderPosterCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String,
    @SerializedName("url") var url: String,
)