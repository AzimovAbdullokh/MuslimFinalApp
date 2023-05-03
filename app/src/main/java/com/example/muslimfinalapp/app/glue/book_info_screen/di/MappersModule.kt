package com.example.muslimfinalapp.app.glue.book_info_screen.di

import com.example.book_info.domain.models.BookFeatureModelDomain
import com.example.book_info.presentation.mappers.BookFeatureModelDomainToUiMapper
import com.example.book_info.presentation.models.BookFeatureModelUi
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.muslimfinalapp.app.glue.book_info_screen.mappers.BookDomainToBookFeatureModulMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    abstract fun bindBookDomainToBookFeatureModulMapper(
        impl: BookDomainToBookFeatureModulMapper,
    ): Mapper<BookDomain, BookFeatureModelDomain>

    @Binds
    abstract fun bindBookFeatureModelDomainToUiMapper(
        impl: BookFeatureModelDomainToUiMapper
    ): com.example.common_api.Mapper<BookFeatureModelDomain, BookFeatureModelUi>
}