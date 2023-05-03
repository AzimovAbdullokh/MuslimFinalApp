package com.example.muslimfinalapp.app.glue.audio_screen.di

import com.example.alarms.presentation.audio_screen.router.AudioScreenRouter
import com.example.muslimfinalapp.app.glue.audio_screen.router.AudioScreenRouterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RouterModule {

    @Binds
    abstract fun bindAudioScreenRouter(
        impl: AudioScreenRouterImpl,
    ): AudioScreenRouter
}