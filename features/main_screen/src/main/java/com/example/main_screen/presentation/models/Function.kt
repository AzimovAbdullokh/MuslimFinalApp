package com.example.main_screen.presentation.models

import com.example.common_api.IdResourceString
import com.example.main_screen.R

enum class Function(val title: IdResourceString, val imageView: Int) {

    MOSQUES(IdResourceString(com.example.ui_core.R.string.mosques), R.drawable.masjiid),

    TASBIH(IdResourceString(com.example.ui_core.R.string.tasbih), R.drawable.tasbeh),

    NAMES(IdResourceString(com.example.ui_core.R.string.names), R.drawable.names);

    companion object {
        fun fetchAllFunctions() = listOf(
            MOSQUES,
            TASBIH,
            NAMES
        )
    }
}