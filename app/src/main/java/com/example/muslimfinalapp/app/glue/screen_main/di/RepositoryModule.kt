package com.example.muslimfinalapp.app.glue.screen_main.di

import com.example.alarms.domain.repository.QuranReadersFeatureRepository
import com.example.main_screen.domain.repository.*
import com.example.muslimfinalapp.app.glue.audio_screen.gluing_repository.AdapterQuranReadersAudioFeatureRepository
import com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun bindAdapterKhadisFeatureRepository(
        impl: AdapterKhadisFeatureRepository
    ):KhadisFeatureRepository

    @Binds
    abstract fun bindSurahFeatureRepository(
        impl: AdapterSurahFeatureRepository
    ): SurahFeatureRepository

    @Binds
    abstract fun bindAdapterQuranReadersAudioFeatureRepository(
        impl: AdapterQuranReadersAudioMainFeatureRepository,
    ): QuranReadersMainFeatureRepository
}