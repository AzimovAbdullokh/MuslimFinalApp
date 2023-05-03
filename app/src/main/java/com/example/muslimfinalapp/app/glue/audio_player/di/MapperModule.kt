package com.example.muslimfinalapp.app.glue.audio_player.di

import com.example.audioservice.service_player.domain.models.NasheedsFeatureModel
import com.example.audioservice.service_player.presentation.mapper.FeatureAudioNasheedDomainToUiMapper
import com.example.audioservice.service_player.presentation.models.AudioNasheedsUi
import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.muslimfinalapp.app.glue.audio_player.mapper.NasheedsDomainToServiceFeatureModelMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindAudioNasheedDomainToUiMapper(
        impl: FeatureAudioNasheedDomainToUiMapper,
    ): Mapper<NasheedsFeatureModel, AudioNasheedsUi>

    @Binds
    abstract fun bindNasheedDomainToFeatureModelMapper(
        impl: NasheedsDomainToServiceFeatureModelMapper,
    ): com.example.domain.domain.domain.Mapper<NasheedsDomain, NasheedsFeatureModel>
}