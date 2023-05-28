package com.example.main_screen.presentation.models.adapter_models

import com.example.common_api.base.adapter.Item
import com.example.main_screen.presentation.listeners.BookMainScreenItemOnClickListener
import java.util.*

data class BookMainScreenAdapterModel(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var posterUrl: String,
    val publicYear:String,
    val pages:String,
    val format:String,
    val listener: BookMainScreenItemOnClickListener,
) : Item
