package com.example.muslimfinalapp.app.glue.screen_main.di

import com.example.common_api.DispatchersProvider
import com.example.domain.domain.domain.repositories.SurahRepository
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
        booksRepository: BookFeatureRepository,
        dispatchersProvider: DispatchersProvider,
        audioBooksRepository: AudioNasheedFeatureRepository,
        khadisRepository: KhadisFeatureRepository,
        readersRepository: QuranReadersFeatureRepository,
        surahRepository: SurahFeatureRepository
    ): FetchAllMainScreenItemsFeatureUseCase = FetchAllMainScreenItemsFeatureUseCaseImpl(
        dispatchersProvider = dispatchersProvider,
        audioNasheedRepository = audioBooksRepository,
        bookRepository = booksRepository,
        khadisRepository = khadisRepository,
        readersRepository = readersRepository,
        surahFeatureRepository = surahRepository
    )


}