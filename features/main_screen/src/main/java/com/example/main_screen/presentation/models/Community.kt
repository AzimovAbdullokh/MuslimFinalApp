package com.example.main_screen.presentation.models

import com.example.common_api.IdResourceString

enum class Community(val title: IdResourceString, val imageView: Int) {
    QURAN(IdResourceString(com.example.ui_core.R.string.surah),
        com.example.ui_core.R.drawable.quran_community),

    TESTS(IdResourceString(com.example.ui_core.R.string.online_tests),
        com.example.ui_core.R.drawable.tests_community),

    KHADISSES(IdResourceString(com.example.ui_core.R.string.khadisses),
        com.example.ui_core.R.drawable.khadis_community),

    BOOKS(IdResourceString(com.example.ui_core.R.string.islamicBooks),
        com.example.ui_core.R.drawable.book_community);


    companion object {
        fun fetchAllCommunities() = listOf(
            QURAN,
            TESTS,
            KHADISSES,
            BOOKS,
        )
    }
}