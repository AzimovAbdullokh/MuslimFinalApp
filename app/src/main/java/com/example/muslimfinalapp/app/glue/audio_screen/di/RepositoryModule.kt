package com.example.muslimfinalapp.app.glue.audio_screen.di

import com.example.alarms.domain.repository.AudioNasheedFeatureRepository
import com.example.alarms.domain.repository.BookFeatureRepository
import com.example.alarms.domain.repository.QuranReadersFeatureRepository
import com.example.muslimfinalapp.app.glue.audio_screen.gluing_repository.AdapterBooksFeatureRepository
import com.example.muslimfinalapp.app.glue.audio_screen.gluing_repository.AdapterNasheedsFeatureRepository
import com.example.muslimfinalapp.app.glue.audio_screen.gluing_repository.AdapterQuranReadersAudioFeatureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun bindAdapterNasheedsFeatureRepository(
        impl: AdapterNasheedsFeatureRepository,
    ): AudioNasheedFeatureRepository

    @Binds
    abstract fun bindAdapterBooksAudioFeatureRepository(
        impl: AdapterBooksFeatureRepository,
    ): BookFeatureRepository

    @Binds
    abstract fun bindAdapterQuranReadersAudioFeatureRepository(
        impl: AdapterQuranReadersAudioFeatureRepository,
    ): QuranReadersFeatureRepository
}