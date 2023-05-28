package com.example.domain.domain.domain.use_cases

import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.models.MainScreenItems
import com.example.domain.domain.domain.repositories.AudioNasheedRepository
import com.example.domain.domain.domain.repositories.BookRepository
import com.example.domain.domain.domain.repositories.KhadisRepository
import com.example.domain.domain.domain.repositories.QuranReadersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn

interface FetchAllMainScreenItemsUseCase {

    operator fun invoke(): Flow<MainScreenItems>
}

class FetchAllMainScreenItemsUseCaseImpl(
    private val dispatchersProvider: DispatchersProvider,
    audioNasheedRepository: AudioNasheedRepository,
    bookRepository: BookRepository,
    khadisRepository: KhadisRepository,
    readersRepository: QuranReadersRepository,
) : FetchAllMainScreenItemsUseCase {

    override fun invoke(): Flow<MainScreenItems> = combine(
        booksFlow,
        nasheedsFlow,
        khadissesFlow,
        readersFlow
    ) { allBooks, savedBooks, khadisses, readers ->
        MainScreenItems(
            books = allBooks,
            audioNasheeds = savedBooks,
            khadisses = khadisses,
            readers = readers
        )
    }.flowOn(dispatchersProvider.default())


    private val booksFlow =
        bookRepository.fetchAllBooks()
            .flowOn(dispatchersProvider.io())

    private val nasheedsFlow =
        audioNasheedRepository.fetchAllAudioNasheeds("38")
            .flowOn(dispatchersProvider.io())

    private val khadissesFlow =
        khadisRepository.fetchAllKhadisses("1")
            .flowOn(dispatchersProvider.io())

    private val readersFlow =
        readersRepository.fetchAllReaders("1")
            .flowOn(dispatchersProvider.io())


}