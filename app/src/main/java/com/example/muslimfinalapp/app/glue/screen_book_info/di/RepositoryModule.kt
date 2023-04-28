package com.example.muslimfinalapp.app.glue.screen_book_info.di

import com.example.book_info.domain.repository.BookFeatureModuleRepository
import com.example.muslimfinalapp.app.glue.screen_book_info.gluing_repository.AdapterBooksFeatureModuleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAdapterMainScreenBooksModuleRepository(
        impl: AdapterBooksFeatureModuleRepository,
    ): BookFeatureModuleRepository
}