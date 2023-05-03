package com.example.muslimfinalapp.app.glue.screen_nasheeds.di

import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.presentation.mappers.MainNasheedFilteredItemsMapper
import com.example.alarms.presentation.mappers.MainNasheedFilteredItemsMapperImpl
import com.example.alarms.presentation.mappers.NasheedFeatureModelToUiMapper
import com.example.alarms.presentation.models.AudioNasheedsUi
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.main_screen.presentation.mappers.MainItemsToSearchFilteredFeatureModelMapper
import com.example.main_screen.presentation.mappers.MainItemsToSearchFilteredFeatureModelMapperImpl
import com.example.muslimfinalapp.app.glue.screen_nasheeds.mapper.NasheedDomainToFeatureModelMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

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
}