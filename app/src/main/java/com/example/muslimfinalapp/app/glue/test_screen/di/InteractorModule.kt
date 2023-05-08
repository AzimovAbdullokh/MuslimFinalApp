package com.example.muslimfinalapp.app.glue.test_screen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import test_screen.test_category_screen.domain.usecase.FetchAllCategoriesUseCase
import test_screen.test_category_screen.domain.usecase.FetchAllCategoriesUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {

    @Binds
    abstract fun bindFetchAllCategoriesUseCase(
        impl: FetchAllCategoriesUseCaseImpl,
    ): FetchAllCategoriesUseCase
}