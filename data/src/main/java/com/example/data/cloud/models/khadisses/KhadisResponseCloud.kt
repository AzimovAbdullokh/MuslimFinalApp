package com.example.data.cloud.models.khadisses

import com.google.gson.annotations.SerializedName

data class KhadisResponseCloud(
    @SerializedName("results")
    val khadisses: List<KhadisCloud>,
)