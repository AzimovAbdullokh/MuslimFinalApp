package com.example.main_screen.domain.usecases

import com.example.common_api.DispatchersProvider
import com.example.main_screen.domain.models.MainScreenFeatureModuleItems
import com.example.main_screen.domain.repository.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchAllMainScreenItemsFeatureUseCaseImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProvider,
    audioNasheedRepository: AudioNasheedFeatureRepository,
    bookRepository: BookFeatureRepository,
    khadisRepository: KhadisFeatureRepository,
    readersRepository: QuranReadersFeatureRepository,
    surahFeatureRepository: SurahFeatureRepository
) : FetchAllMainScreenItemsFeatureUseCase {

    override fun invoke(): Flow<MainScreenFeatureModuleItems> = combine(
        booksFlow,
        nasheedsFlow,
        khadissesFlow,
        readersFlow,
        surahFlow
    ) { allBooks, savedBooks, khadisses, readers, surah ->
        MainScreenFeatureModuleItems(
            books = allBooks,
            audioNasheeds = savedBooks,
            khadisses = khadisses,
            readers = readers,
            surah = surah
        )
    }.flowOn(dispatchersProvider.default())


    private val booksFlow =
        bookRepository.fetchAllBooks("1").flowOn(dispatchersProvider.io())

    private val nasheedsFlow =
        audioNasheedRepository.fetchAllAudioNasheeds("38").flowOn(dispatchersProvider.io())

    private val khadissesFlow =
        khadisRepository.fetchAllKhadisses("1").flowOn(dispatchersProvider.io())

    private val readersFlow =
        readersRepository.fetchAllReaders("1").flowOn(dispatchersProvider.io())

    private val surahFlow =
        surahFeatureRepository.fetchAllSurah("1").flowOn(dispatchersProvider.io())


}