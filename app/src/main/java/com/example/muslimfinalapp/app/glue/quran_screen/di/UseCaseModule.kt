package com.example.muslimfinalapp.app.glue.quran_screen.di

import com.example.common_api.DispatchersProviderInCommonApi
import com.example.main_quran.domain.repository.QuranFeatureRepository
import com.example.main_quran.domain.usecases.FetchAllQuransUseCase
import com.example.main_quran.domain.usecases.FetchAllQuransUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideFetchMainQuranItemsUseCase(
        dispatchersProvider: DispatchersProviderInCommonApi,
        quranFeatureRepository: QuranFeatureRepository,
    ): FetchAllQuransUseCase = FetchAllQuransUseCaseImpl(
        dispatchersProvider = dispatchersProvider,
        quranFeatureRepository = quranFeatureRepository
    )
}