package com.example.main_screen.presentation.models.adapter_models

import com.example.common_api.base.adapter.Item
import com.example.main_screen.presentation.listeners.KhadisItemOnClickListener
import java.util.*

data class KhadisAdapterModel(
    val id: String,
    val title: String,
    val createdAt: Date,
    val khadisId: String,
    val khadisDescription: String,
    val khadisSubject: String,
    val listener: KhadisItemOnClickListener,
) : Item