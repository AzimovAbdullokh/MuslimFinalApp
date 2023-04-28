package com.example.muslimfinalapp.app.di

import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.repositories.AudioNasheedRepository
import com.example.domain.domain.domain.repositories.BookRepository
import com.example.domain.domain.domain.repositories.KhadisRepository
import com.example.domain.domain.domain.repositories.QuranReadersRepository
import com.example.domain.domain.domain.use_cases.FetchAllMainScreenItemsUseCase
import com.example.domain.domain.domain.use_cases.FetchAllMainScreenItemsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

    @Provides
    fun provideFetchAllMainItemsUseCase(
        booksRepository: BookRepository,
        dispatchersProvider: DispatchersProvider,
        audioBooksRepository: AudioNasheedRepository,
        khadisRepository: KhadisRepository,
        readersRepository: QuranReadersRepository,
    ): FetchAllMainScreenItemsUseCase =
        FetchAllMainScreenItemsUseCaseImpl(
            dispatchersProvider = dispatchersProvider,
            audioNasheedRepository = audioBooksRepository,
            bookRepository = booksRepository,
            khadisRepository = khadisRepository,
            readersRepository = readersRepository
        )
}