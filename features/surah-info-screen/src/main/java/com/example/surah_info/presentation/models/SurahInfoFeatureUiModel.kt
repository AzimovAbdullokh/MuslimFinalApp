package com.example.surah_info.presentation.models

class SurahInfoFeatureUiModel(
    val id: String,
    val surahId:String,
    val surahName: String,
    val surahArabName: String,
    val surahCountInQuran: String,
    val surah: String,
) {
    companion object {
        val unknown = SurahInfoFeatureUiModel(
            id = String(),
            surahCountInQuran = String(),
            surahArabName = String(),
            surahName = String(),
            surahId = String(),
            surah = String(),
        )
    }
}