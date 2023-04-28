package com.example.data.cloud.models.category

import com.google.gson.annotations.SerializedName

data class CategoryCloud(
    @SerializedName("objectId") val id: String,
    @SerializedName("title") val titles: String,
    @SerializedName("description") val descriptions: String,
    @SerializedName("poster") val poster: CategoryPosterCloud,
)

data class CategoryPosterCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String,
    @SerializedName("url") var url: String,
)