package com.example.data.cloud.models.readers

import com.google.gson.annotations.SerializedName

data class ReadersResponse(
    @SerializedName("results")
    val readers: List<ReadersCloud>,
)