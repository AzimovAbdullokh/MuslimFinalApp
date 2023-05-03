package com.example.alarms.domain.usecases

import com.example.alarms.domain.models.MainNasheedItems
import com.example.alarms.domain.repository.AudioNasheedFeatureRepository
import com.example.alarms.domain.repository.BookFeatureRepository
import com.example.alarms.domain.repository.QuranReadersFeatureRepository
import com.example.common_api.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchAllNasheedsUseCaseImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProvider,
    nasheedFeatureRepository: AudioNasheedFeatureRepository,
    bookRepository: BookFeatureRepository,
    readersRepository: QuranReadersFeatureRepository,
) : FetchAllNasheedsUseCase {

    override fun invoke(): Flow<MainNasheedItems> = combine(
        nasheedFlow,
        booksFlow,
        readersFlow
    ) { nasheeds, books, readers ->
        MainNasheedItems(
            nasheeds = nasheeds,
            books = books,
            readers = readers
        )
    }.flowOn(dispatchersProvider.default())

    private val nasheedFlow =
        nasheedFeatureRepository.fetchAllAudioNasheeds("38").flowOn(dispatchersProvider.io())

    private val booksFlow =
        bookRepository.fetchAllBooks("1").flowOn(dispatchersProvider.io())

    private val readersFlow =
        readersRepository.fetchAllReaders("1").flowOn(dispatchersProvider.io())

}