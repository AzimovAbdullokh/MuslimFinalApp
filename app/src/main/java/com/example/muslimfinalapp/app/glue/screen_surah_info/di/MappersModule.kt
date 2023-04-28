package com.example.muslimfinalapp.app.glue.screen_surah_info.di

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.muslimfinalapp.app.glue.screen_surah_info.mappers.SurahInfoDomainToFeatureModelMapper
import com.example.surah_info.domain.models.SurahInfoFeatureModuleDomainModel
import com.example.surah_info.presentation.mappers.SurahInfoFeatureDomainModelToUiMapper
import com.example.surah_info.presentation.models.SurahInfoFeatureUiModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    abstract fun bindSurahInfoDomainToFeatureModelMapper(
        impl: SurahInfoDomainToFeatureModelMapper,
    ): Mapper<SurahDomain, SurahInfoFeatureModuleDomainModel>

    @Binds
    abstract fun bindSurahInfoFeatureDomainModelToUiMapper(
        impl: SurahInfoFeatureDomainModelToUiMapper
    ): com.example.common_api.Mapper<SurahInfoFeatureModuleDomainModel, SurahInfoFeatureUiModel>
}