package com.example.alarms.presentation.audio_screen.models.adapter_models

import com.example.alarms.presentation.audio_screen.listeners.BookItemOnClickListener
import com.example.common_api.base.adapter.Item
import java.util.*

data class BookAdapterModel(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var posterUrl: String,
    val listener: BookItemOnClickListener,
) : Item
