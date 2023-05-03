package com.example.main_quran.presentation.router

import com.example.common_api.navigation.NavCommand

interface FragmentMainQuranRouter {

    fun navigateToSurahInfoFragment(surahId: String): NavCommand

}