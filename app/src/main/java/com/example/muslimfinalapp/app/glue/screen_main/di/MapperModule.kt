package com.example.muslimfinalapp.app.glue.screen_main.di

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.alarms.domain.models.books.BookFeatureModel
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.alarms.domain.models.readers.ReadersFeatureModel
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
    abstract fun bindKhadisDomainToFeatureModelMapper(
        impl: KhadisDomainToFeatureModelMapper,
    ): Mapper<KhadisDomain, KhadisFeatureModel>


    @Binds
    abstract fun bindKhadisFeatureModelToUiMapper(
        impl: KhadisFeatureModelToUiMapper,
    ): com.example.common_api.Mapper<KhadisFeatureModel, KhadissesFeatureUi>


    @Binds
    abstract fun bindSurahDomainToFeatureModelMapper(
        impl: SurahDomainToFeatureModelMapper,
    ): Mapper<SurahDomain, SurahFeatureModuleDomainModel>

    @Binds
    abstract fun bindSurahFeatureDomainModelToUiMapper(
        impl: SurahFeatureDomainModelToUiMapper,
    ): com.example.common_api.Mapper<SurahFeatureModuleDomainModel, SurahFeatureUiModel>
}