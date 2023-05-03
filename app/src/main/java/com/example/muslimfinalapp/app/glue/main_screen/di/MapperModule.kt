package com.example.muslimfinalapp.app.glue.main_screen.di

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.main_quran.domain.models.QuranFeatureModuleDomainModel
import com.example.main_quran.presentation.mappers.MainQuranFilteredItemsMapper
import com.example.main_quran.presentation.mappers.MainQuranFilteredItemsMapperImpl
import com.example.main_quran.presentation.mappers.QuranFeatureDomainModelToUiMapper
import com.example.main_quran.presentation.models.QuranFeatureUiModel
import com.example.muslimfinalapp.app.glue.main_screen.mapper.QuranDomainToFeatureModelMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindMainQuranFilteredItemsMapper(
        impl: MainQuranFilteredItemsMapperImpl,
    ): MainQuranFilteredItemsMapper

    @Binds
    abstract fun bindSurahDomainToFeatureModelMapper(
        impl: QuranDomainToFeatureModelMapper,
    ): Mapper<SurahDomain, QuranFeatureModuleDomainModel>

    @Binds
    abstract fun bindQuranFeatureDomainModelToUiMapper(
        impl: QuranFeatureDomainModelToUiMapper
    ): com.example.common_api.Mapper<QuranFeatureModuleDomainModel, QuranFeatureUiModel>
}