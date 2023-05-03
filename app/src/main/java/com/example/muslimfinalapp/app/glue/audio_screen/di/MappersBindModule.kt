package com.example.muslimfinalapp.app.glue.audio_screen.di

import com.example.alarms.domain.models.books.BookFeatureModel
import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.domain.models.readers.ReadersFeatureModel
import com.example.alarms.presentation.audio_screen.mappers.*
import com.example.alarms.presentation.audio_screen.models.AudioNasheedsUi
import com.example.alarms.presentation.audio_screen.models.BooksFeatureModelUi
import com.example.alarms.presentation.audio_screen.models.ReadersFeatureUiModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.muslimfinalapp.app.glue.audio_screen.mapper.BookDomainToBookFeatureModelMapper
import com.example.muslimfinalapp.app.glue.audio_screen.mapper.NasheedDomainToFeatureModelMapper
import com.example.muslimfinalapp.app.glue.audio_screen.mapper.ReaderDomainToFeatureModelMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersBindModule {

    @Binds
    abstract fun bindMainItemsToSearchFilteredModelMapper(
        impl: MainNasheedFilteredItemsMapperImpl,
    ): MainNasheedFilteredItemsMapper

    @Binds
    abstract fun bindNasheedFeatureModelToUiMapper(
        impl: NasheedFeatureModelToUiMapper,
    ): com.example.common_api.Mapper<NasheedsFeatureModel, AudioNasheedsUi>

    @Binds
    abstract fun bindNasheedDomainToFeatureModelMapper(
        impl: NasheedDomainToFeatureModelMapper,
    ): Mapper<NasheedsDomain, NasheedsFeatureModel>

    @Binds
    abstract fun bindBookDomainToBookFeatureModelMapper(
        impl: BookDomainToBookFeatureModelMapper,
    ): Mapper<BookDomain, BookFeatureModel>

    @Binds
    abstract fun bindReaderDomainToFeatureModelMapper(
        impl: ReaderDomainToFeatureModelMapper,
    ): Mapper<ReaderDomain, ReadersFeatureModel>

    @Binds
    abstract fun bindBookFeatureModelToFeatureModelUiMapper(
        impl: BookFeatureModelToFeatureModelUiMapper,
    ): com.example.common_api.Mapper<BookFeatureModel, BooksFeatureModelUi>

    @Binds
    abstract fun bindReaderFeatureModelToUiMapper(
        impl: ReaderFeatureModelToUiMapper,
    ): com.example.common_api.Mapper<ReadersFeatureModel, ReadersFeatureUiModel>
}