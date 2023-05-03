package com.example.muslimfinalapp.app.glue.audio_screen.router

import com.example.alarms.presentation.audio_screen.NasheedsFragmentDirections
import com.example.alarms.presentation.audio_screen.router.AudioScreenRouter
import com.example.common_api.navigation.NavCommand
import com.example.common_api.navigation.toNavCommand
import javax.inject.Inject

class AudioScreenRouterImpl @Inject constructor() : AudioScreenRouter {

    override fun navigateToSearchAudioFragment(): NavCommand =
        NasheedsFragmentDirections.actionScreenNasheedsToSearchAudioFragment()
            .toNavCommand()
}