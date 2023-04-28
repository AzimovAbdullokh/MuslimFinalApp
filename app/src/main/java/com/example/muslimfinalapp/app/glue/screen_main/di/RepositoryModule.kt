package com.example.muslimfinalapp.app.glue.screen_main.di

import com.example.main_screen.domain.repository.*
import com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAdapterMainScreenBooksModuleRepository(
        impl: AdapterBooksFeatureRepository,
    ): BookFeatureRepository

    @Binds
    abstract fun bindAdapterNasheedsFeatureRepository(
        impl: AdapterNasheedsFeatureRepository,
    ): AudioNasheedFeatureRepository

    @Binds
    abstract fun bindAdapterKhadisFeatureRepository(
        impl: AdapterKhadisFeatureRepository
    ):KhadisFeatureRepository

    @Binds
    abstract fun bindAdapterQuranReadersFeatureRepository(
        impl: AdapterQuranReadersFeatureRepository
    ):QuranReadersFeatureRepository

    @Binds
    abstract fun bindSurahFeatureRepository(
        impl: AdapterSurahFeatureRepository
    ): SurahFeatureRepository
}