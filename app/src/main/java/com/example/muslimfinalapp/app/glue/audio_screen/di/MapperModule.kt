package com.example.muslimfinalapp.app.glue.audio_screen.di

import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.presentation.audio_screen.mappers.MainNasheedFilteredItemsMapper
import com.example.alarms.presentation.audio_screen.mappers.MainNasheedFilteredItemsMapperImpl
import com.example.alarms.presentation.audio_screen.mappers.NasheedFeatureModelToUiMapper
import com.example.alarms.presentation.audio_screen.models.AudioNasheedsUi
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.muslimfinalapp.app.glue.audio_screen.mapper.NasheedDomainToFeatureModelMapper
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