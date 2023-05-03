package com.example.muslimfinalapp.app.glue.audio_screen.di

import com.example.alarms.domain.repository.AudioNasheedFeatureRepository
import com.example.alarms.domain.repository.BookFeatureRepository
import com.example.alarms.domain.repository.QuranReadersFeatureRepository
import com.example.alarms.domain.usecases.FetchAllNasheedsUseCase
import com.example.alarms.domain.usecases.FetchAllNasheedsUseCaseImpl
import com.example.common_api.DispatchersProvider
import com.example.domain.domain.domain.repositories.BookRepository
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
        audioBooksRepository: AudioNasheedFeatureRepository,
        booksRepository: BookFeatureRepository,
        readersFeatureRepository: QuranReadersFeatureRepository
    ): FetchAllNasheedsUseCase = FetchAllNasheedsUseCaseImpl(
        dispatchersProvider = dispatchersProvider,
        nasheedFeatureRepository = audioBooksRepository,
        bookRepository = booksRepository,
        readersRepository = readersFeatureRepository
    )
}