package com.example.main_quran.presentation.models

import com.example.common_api.base.adapter.Item
import com.example.main_quran.presentation.listener.QuranItemOnClickListener

data class QuranAdapterModel(
    val id: String,
    val surahId: String,
    val surahName: String,
    val surahArabName: String,
    val surahCountInQuran: String,
    val listener: QuranItemOnClickListener,
) : Item