package com.example.main_screen.presentation.router

import com.example.common_api.navigation.NavCommand

interface FragmentMainScreenRouter {

    fun navigateToBookInfoFragment(bookId: String): NavCommand

    fun navigateToSurahInfoFragment(surahId: String): NavCommand

    fun navigateToMainBooksFragment(): NavCommand

    fun navigateToMainKhadissesFragment(): NavCommand

    fun navigateToMainTestsFragment(): NavCommand

    fun navigateToMainQuranFragment(): NavCommand

    fun navigateToNamazTimesScreen(): NavCommand

    fun navigateToTasbihScreen(): NavCommand

    fun navigateToAllBooksScreen(): NavCommand
}