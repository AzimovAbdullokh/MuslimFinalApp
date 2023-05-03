package com.example.main_screen.presentation.models.adapter_models

import com.example.common_api.base.adapter.Item
import com.example.main_screen.presentation.listeners.ReaderItemOnClickListener

data class ReadersAdapterModel(
    val id: String,
    val readerId: String,
    val readerName: String,
    val posterUrl: String,
    val listener: ReaderItemOnClickListener,
) : Item