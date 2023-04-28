package com.example.main_quran.domain.models

data class QuranFeatureModuleDomainModel(
    val id: String,
    val surahId: String,
    val surahName: String,
    val surahArabName: String,
    val surahCountInQuran: String,
    val surah: String,
)