package com.example.navigation.navigation

import com.example.navigation.navigation.NavigationMode
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class NavigationModeHolder @Inject constructor() {

    var navigationMode: NavigationMode = NavigationMode.Stack

}