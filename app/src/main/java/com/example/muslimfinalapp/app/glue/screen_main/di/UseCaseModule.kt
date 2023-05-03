package com.example.muslimfinalapp.app.glue.screen_main.di

import com.example.common_api.DispatchersProvider
import com.example.main_screen.domain.repository.*
import com.example.main_screen.domain.usecases.FetchAllMainScreenItemsFeatureUseCase
import com.example.main_screen.domain.usecases.FetchAllMainScreenItemsFeatureUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideFetchAllMainItemsFeatureUseCase(
        dispatchersProvider: DispatchersProvider,
//        audioBooksRepository: AudioNasheedFeatureRepository,
        khadisRepository: KhadisFeatureRepository,
        surahRepository: SurahFeatureRepository,
    ): FetchAllMainScreenItemsFeatureUseCase = FetchAllMainScreenItemsFeatureUseCaseImpl(
        dispatchersProvider = dispatchersProvider,
//        audioNasheedRepository = audioBooksRepository,
        khadisRepository = khadisRepository,
        surahFeatureRepository = surahRepository
    )


}