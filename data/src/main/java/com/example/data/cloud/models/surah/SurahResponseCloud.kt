package com.example.data.cloud.models.surah

import com.google.gson.annotations.SerializedName

data class SurahResponseCloud(
    @SerializedName("results")
    val surah: List<SurahCloud>,
)