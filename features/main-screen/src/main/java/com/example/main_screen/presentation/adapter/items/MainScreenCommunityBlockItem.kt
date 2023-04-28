package com.example.main_screen.presentation.adapter.items

import android.os.Parcelable
import com.example.common_api.base.adapter.Item

data class MainScreenCommunityBlockItem(
    val items: List<Item>,
    var state: Parcelable? = null
) : Item