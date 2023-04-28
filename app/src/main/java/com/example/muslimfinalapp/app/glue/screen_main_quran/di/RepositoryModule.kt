package com.example.muslimfinalapp.app.glue.screen_main_quran.di

import com.example.main_quran.domain.repository.QuranFeatureRepository
import com.example.muslimfinalapp.app.glue.screen_main_quran.gluing_repository.AdapterQuranFeatureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAdapterQuranFeatureRepository(
        impl: AdapterQuranFeatureRepository,
    ): QuranFeatureRepository
}