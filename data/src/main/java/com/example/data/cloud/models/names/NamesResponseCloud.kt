package com.example.data.cloud.models.names

import com.google.gson.annotations.SerializedName

data class NamesResponseCloud(
    @SerializedName("results") val names: List<NamesCloud>,
)