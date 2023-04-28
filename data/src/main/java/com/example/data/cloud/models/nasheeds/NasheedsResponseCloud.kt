package com.example.data.cloud.models.nasheeds

import com.google.gson.annotations.SerializedName

data class NasheedsResponseCloud(
    @SerializedName("results")
    var nasheeds: List<NasheedsCloud>,
)