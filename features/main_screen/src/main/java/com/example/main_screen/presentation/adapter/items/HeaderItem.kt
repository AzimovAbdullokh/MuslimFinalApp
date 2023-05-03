package com.example.main_screen.presentation.adapter.items

import com.example.common_api.IdResourceString
import com.example.common_api.base.adapter.Item

data class HeaderItem(
    val onClickListener: () -> Unit,
    val titleId: IdResourceString,
    val showMoreIsVisible: Boolean = false
) : Item