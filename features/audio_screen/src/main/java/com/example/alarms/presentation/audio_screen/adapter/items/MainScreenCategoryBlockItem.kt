package com.example.alarms.presentation.audio_screen.adapter.items

import android.os.Parcelable
import com.example.common_api.base.adapter.Item

data class MainScreenCategoryBlockItem(
    val items: List<Item>,
    var state: Parcelable? = null
) : Item