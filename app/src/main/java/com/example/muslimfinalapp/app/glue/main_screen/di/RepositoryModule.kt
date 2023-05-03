package com.example.muslimfinalapp.app.glue.main_screen.di

import com.example.main_quran.domain.repository.QuranFeatureRepository
import com.example.muslimfinalapp.app.glue.main_screen.gluing_repository.AdapterQuranFeatureRepository
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