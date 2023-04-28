package com.example.muslimfinalapp.app.utils.extensions

import androidx.navigation.NavController
import com.example.muslimfinalapp.app.utils.navigation.NavCommand

fun NavController.navigateTo(navCommand: NavCommand) {
    navigate(navCommand.resId, navCommand.args)
}