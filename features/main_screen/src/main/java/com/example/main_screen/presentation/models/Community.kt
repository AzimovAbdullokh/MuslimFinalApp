package com.example.main_screen.presentation.models

import com.example.common_api.IdResourceString

enum class Community(val title: IdResourceString, val imageView: Int) {

    QURAN(IdResourceString(com.example.ui_core.R.string.surah),
        com.example.ui_core.R.drawable.quran_quran_svgrepo_com),

    TESTS(IdResourceString(com.example.ui_core.R.string.online_tests),
        com.example.ui_core.R.drawable.tests_community),

    NAMAZ_TIMES(IdResourceString(com.example.ui_core.R.string.prayer_time),
        com.example.ui_core.R.drawable.mosque_svgrepo_com__3_),

    BOOKS(IdResourceString(com.example.ui_core.R.string.islamicBooks),
        com.example.ui_core.R.drawable.book_closed_svgrepo_com),

    KHADISSES(IdResourceString(com.example.ui_core.R.string.khadisses),
        com.example.ui_core.R.drawable.write_svgrepo_com),

    TASBIH(IdResourceString(com.example.ui_core.R.string.tasbih),
        com.example.ui_core.R.drawable.prayer_beads_svgrepo_com),

    QIBLA(IdResourceString(com.example.ui_core.R.string.qibla),
        com.example.ui_core.R.drawable.kaaba_svgrepo_com__1_),

  MOSQUES(IdResourceString(com.example.ui_core.R.string.mosques),
        com.example.ui_core.R.drawable.mosque_svgrepo_com__2_),

  DUAS(IdResourceString(com.example.ui_core.R.string.duas),
        com.example.ui_core.R.drawable.prayer_pray_svgrepo_com);


    companion object {
        fun fetchAllCommunities() = listOf(
            QURAN,
            TESTS,
            NAMAZ_TIMES,
            KHADISSES,
            TASBIH,
            QIBLA,
            MOSQUES,
            DUAS
        )
    }
}