package com.example.muslimfinalapp.app.di

import com.example.audioservice.service_player.service_player.PlaybackManager
import com.example.audioservice.service_player.service_player.PlaybackManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HelperModule {

    @Binds
    abstract fun providePlaybackManager(impl: PlaybackManagerImpl): PlaybackManager


}