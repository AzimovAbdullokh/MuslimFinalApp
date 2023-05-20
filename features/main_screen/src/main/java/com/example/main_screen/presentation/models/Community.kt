package com.example.main_screen.presentation.models

import com.example.common_api.IdResourceString
import com.example.main_screen.R

enum class Community(val title: IdResourceString, val imageView: Int) {

    QURAN(IdResourceString(com.example.ui_core.R.string.surah),
        R.drawable.quran_image),

    TESTS(IdResourceString(com.example.ui_core.R.string.online_tests),
        R.drawable.test_images),

    NAMAZ_TIMES(IdResourceString(com.example.ui_core.R.string.prayer_time),
        R.drawable.namaz_times),

    BOOKS(IdResourceString(com.example.ui_core.R.string.islamicBooks),
        R.drawable.islamic_books),

    KHADISSES(IdResourceString(com.example.ui_core.R.string.khadisses),
        R.drawable.khadis_image),

    TASBIH(IdResourceString(com.example.ui_core.R.string.tasbih),
        R.drawable.tasbih_image),

    QIBLA(IdResourceString(com.example.ui_core.R.string.qibla),
        R.drawable.qibla_image),

    MOSQUES(IdResourceString(com.example.ui_core.R.string.mosques),
        R.drawable.mosque_image),

    DUAS(IdResourceString(com.example.ui_core.R.string.duas),
        R.drawable.dua_image),

    NAMES(IdResourceString(com.example.ui_core.R.string.names),
    R.drawable.names_images);


    companion object {
        fun fetchAllCommunities() = listOf(
            QURAN,
            TESTS,
            NAMAZ_TIMES,
            KHADISSES,
            TASBIH,
            QIBLA,
            MOSQUES,
            DUAS,
            NAMES
        )
    }
}