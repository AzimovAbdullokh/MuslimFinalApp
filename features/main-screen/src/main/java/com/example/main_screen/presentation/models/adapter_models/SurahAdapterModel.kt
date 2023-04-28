package com.example.main_screen.presentation.models.adapter_models

import com.example.common_api.base.adapter.Item
import com.example.main_screen.presentation.listeners.SurahItemOnClickListener

data class SurahAdapterModel(
    val id: String,
    val surahId: String,
    val surahName: String,
    val surahArabName: String,
    val surahCountInQuran: String,
    val listener: SurahItemOnClickListener,
) : Item