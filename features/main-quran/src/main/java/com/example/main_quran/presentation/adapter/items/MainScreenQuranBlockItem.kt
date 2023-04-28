package com.example.main_quran.presentation.adapter.items

import android.os.Parcelable
import com.example.common_api.base.adapter.Item

data class MainScreenQuranBlockItem(
    val items: List<Item>,
    var state: Parcelable? = null
) : Item