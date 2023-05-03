package com.example.muslimfinalapp.app.glue.surah_info_screen.di

import com.example.muslimfinalapp.app.glue.surah_info_screen.gluing_repository.AdapterSurahInfoFeatureModuleRepository
import com.example.surah_info.domain.repository.SurahInfoFeatureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAdapterSurahInfoFeatureModuleRepository(
        impl: AdapterSurahInfoFeatureModuleRepository
    ): SurahInfoFeatureRepository
}