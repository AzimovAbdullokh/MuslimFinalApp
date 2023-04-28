package com.example.main_screen.presentation.adapter.items

import com.example.common_api.base.adapter.Item

data class MainCardItem(
    val listener: MainCardItemClickListener,
) : Item

interface MainCardItemClickListener {

    fun onClick()
}
