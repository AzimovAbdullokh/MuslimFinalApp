package com.example.muslimfinalapp.app.glue.screen_nasheeds.di

import com.example.alarms.domain.repository.AudioNasheedFeatureRepository
import com.example.muslimfinalapp.app.glue.screen_nasheeds.gluing_repository.AdapterNasheedsFeatureRepository
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
}