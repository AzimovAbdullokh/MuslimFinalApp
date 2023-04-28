package com.example.data.cloud.models.surah

import com.google.gson.annotations.SerializedName
import java.util.*

data class SurahCloud(
    @SerializedName("objectId") val id: String,
    @SerializedName("surahId") val surahId: String,
    @SerializedName("surahName") val surahName: String,
    @SerializedName("surahArabName") val surahArabName: String,
    @SerializedName("surahCountInQuran") val surahCountInQuran: String,
    @SerializedName("surah") val surah: String,
) {
    companion object {
        val unknown = SurahCloud(
            id = String(),
            surahCountInQuran = String(),
            surahArabName = String(),
            surahName = String(),
            surahId = String(),
            surah = String(),
        )
    }
}