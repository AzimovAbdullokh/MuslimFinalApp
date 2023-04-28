package com.example.data.data.models.surah

class SurahData(
    val id: String,
    val surahId: String,
    val surahName: String,
    val surahArabName: String,
    val surahCountInQuran: String,
    val surah: String,
) {
    companion object {
        val unknown = SurahData(
            id = String(),
            surahCountInQuran = String(),
            surahArabName = String(),
            surahName = String(),
            surahId = String(),
            surah = String(),
        )
    }
}

