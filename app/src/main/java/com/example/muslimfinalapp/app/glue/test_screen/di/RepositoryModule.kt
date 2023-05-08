package com.example.muslimfinalapp.app.glue.test_screen.di

import com.example.muslimfinalapp.app.glue.test_screen.gluing.AdapterCategoryFeatureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import test_screen.test_category_screen.domain.repository.CategoryFeatureRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAdapterCategoryFeatureRepository(
        impl: AdapterCategoryFeatureRepository,
    ): CategoryFeatureRepository
}