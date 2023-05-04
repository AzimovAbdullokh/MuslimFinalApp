package com.example.muslimfinalapp.app.temporary_screens.splash

sealed class StartNavigationDestination {

    object NavigateToLoginScreen : StartNavigationDestination()

    object NavigateToMainScreen : StartNavigationDestination()

    object NavigateToAdminScreen : StartNavigationDestination()

    object NavigateToAccountHasDeletedScreen : StartNavigationDestination()
}