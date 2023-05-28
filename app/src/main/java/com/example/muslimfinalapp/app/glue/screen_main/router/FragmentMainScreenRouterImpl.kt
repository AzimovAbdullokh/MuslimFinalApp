package com.example.muslimfinalapp.app.glue.screen_main.router

import com.example.common_api.navigation.NavCommand
import com.example.common_api.navigation.toNavCommand
import com.example.main_screen.presentation.MainScreenFragmentDirections
import com.example.main_screen.presentation.router.FragmentMainScreenRouter
import javax.inject.Inject

class FragmentMainScreenRouterImpl @Inject constructor() : FragmentMainScreenRouter {

    override fun navigateToBookInfoFragment(bookId: String): NavCommand =
        MainScreenFragmentDirections
            .actionHomeScreenMainToBookDetailsFragment(id = bookId)
            .toNavCommand()

    override fun navigateToSurahInfoFragment(surahId: String): NavCommand =
        MainScreenFragmentDirections.actionHomeScreenMainToSurahInfoFragment(surahId).toNavCommand()

    override fun navigateToMainBooksFragment(): NavCommand {
        TODO("Not yet implemented")
    }

    override fun navigateToMainKhadissesFragment(): NavCommand {
        TODO()
    }


    override fun navigateToMainTestsFragment(): NavCommand =
        MainScreenFragmentDirections
            .actionHomeScreenMainToTestFragment()
            .toNavCommand()

    override fun navigateToMainQuranFragment(): NavCommand =
        MainScreenFragmentDirections
            .actionHomeScreenMainToMainQuranScreenFragment()
            .toNavCommand()

    override fun navigateToNamazTimesScreen(): NavCommand =
        MainScreenFragmentDirections
            .actionHomeScreenMainToNamazTimesFragment()
            .toNavCommand()

    override fun navigateToTasbihScreen(): NavCommand =
        MainScreenFragmentDirections
            .actionHomeScreenMainToTasbihFragment()
            .toNavCommand()


    override fun navigateToAllBooksScreen(): NavCommand =
        MainScreenFragmentDirections
            .actionHomeScreenMainToAllBooksFragment()
            .toNavCommand()


}