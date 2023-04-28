package com.example.muslimfinalapp.app.utils.navigation

import androidx.navigation.NavDirections

sealed class NavigationCommand {

    data class ToDirection(val directions: NavDirections) : NavigationCommand()

    object Back : NavigationCommand()
}