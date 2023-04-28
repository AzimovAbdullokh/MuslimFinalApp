package com.example.muslimfinalapp.app.glue.screen_main.di

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.main_screen.domain.models.books.BookFeatureModel
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.models.nasheeds.NasheedsFeatureModel
import com.example.main_screen.domain.models.readers.ReadersFeatureModel
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import com.example.main_screen.presentation.mappers.*
import com.example.main_screen.presentation.models.*
import com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindMainItemsToSearchFilteredModelMapper(
        impl: MainItemsToSearchFilteredFeatureModelMapperImpl,
    ): MainItemsToSearchFilteredFeatureModelMapper

    @Binds
    abstract fun bindBookDomainToBookFeatureModelMapper(
        impl: BookDomainToBookFeatureModelMapper,
    ): Mapper<BookDomain, BookFeatureModel>

    @Binds
    abstract fun bindNasheedDomainToFeatureModelMapper(
        impl: NasheedDomainToFeatureModelMapper,
    ): Mapper<NasheedsDomain, NasheedsFeatureModel>

    @Binds
    abstract fun bindKhadisDomainToFeatureModelMapper(
        impl: KhadisDomainToFeatureModelMapper,
    ): Mapper<KhadisDomain, KhadisFeatureModel>

    @Binds
    abstract fun bindReaderDomainToFeatureModelMapper(
        impl: ReaderDomainToFeatureModelMapper,
    ): Mapper<ReaderDomain, ReadersFeatureModel>

    @Binds
    abstract fun bindBookFeatureModelToFeatureModelUiMapper(
        impl: BookFeatureModelToFeatureModelUiMapper,
    ): com.example.common_api.Mapper<BookFeatureModel, BooksFeatureModelUi>

    @Binds
    abstract fun bindNasheedFeatureModelToUiMapper(
        impl: NasheedFeatureModelToUiMapper,
    ): com.example.common_api.Mapper<NasheedsFeatureModel, AudioNasheedsUi>

    @Binds
    abstract fun bindKhadisFeatureModelToUiMapper(
        impl: KhadisFeatureModelToUiMapper,
    ): com.example.common_api.Mapper<KhadisFeatureModel, KhadissesFeatureUi>

    @Binds
    abstract fun bindReaderFeatureModelToUiMapper(
        impl: ReaderFeatureModelToUiMapper,
    ): com.example.common_api.Mapper<ReadersFeatureModel, ReadersFeatureUiModel>

    @Binds
    abstract fun bindSurahDomainToFeatureModelMapper(
        impl: SurahDomainToFeatureModelMapper,
    ): Mapper<SurahDomain, SurahFeatureModuleDomainModel>

    @Binds
    abstract fun bindSurahFeatureDomainModelToUiMapper(
        impl: SurahFeatureDomainModelToUiMapper,
    ): com.example.common_api.Mapper<SurahFeatureModuleDomainModel, SurahFeatureUiModel>
}