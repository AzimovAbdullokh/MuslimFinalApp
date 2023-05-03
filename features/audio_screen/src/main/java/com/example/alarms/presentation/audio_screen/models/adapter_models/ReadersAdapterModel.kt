package com.example.alarms.presentation.audio_screen.models.adapter_models

import com.example.alarms.presentation.audio_screen.listeners.ReaderItemOnClickListener
import com.example.common_api.base.adapter.Item

data class ReadersAdapterModel(
    val id: String,
    val readerId: String,
    val readerName: String,
    val posterUrl: String,
    val listener: ReaderItemOnClickListener,
) : Item