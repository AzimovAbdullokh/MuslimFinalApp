package com.example.muslimfinalapp.app.glue.audioservice.di

import com.example.audioservice.service_player.domain.repository.FeatureAudioRepository
import com.example.muslimfinalapp.app.glue.audioservice.gluing_repository.AdapterFeatureAudioNasheedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindFeatureAudioRepository(
        impl: AdapterFeatureAudioNasheedRepository,
    ): FeatureAudioRepository
}