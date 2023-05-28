package com.example.main_screen.domain.usecases

import com.example.common_api.DispatchersProviderInCommonApi
import com.example.main_screen.domain.models.MainScreenFeatureModuleItems
import com.example.main_screen.domain.repository.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchAllMainScreenItemsFeatureUseCaseImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProviderInCommonApi,
    khadisRepository: KhadisFeatureRepository,
    bookMainScreenFeatureRepository: BookMainScreenFeatureRepository,
    surahFeatureRepository: SurahFeatureRepository,
    readersRepository: QuranReadersMainFeatureRepository,
    categoryFeatureRepository: CategoryMainScreenFeatureRepository,
) : FetchAllMainScreenItemsFeatureUseCase {

    override fun invoke(): Flow<MainScreenFeatureModuleItems> = combine(khadissesFlow,
        surahFlow,
        readersFlow,
        booksFlow,
        categoryFlow
    ) { khadisses, surah, readers, books, categories ->
        MainScreenFeatureModuleItems(
            khadisses = khadisses,
            surah = surah,
            readers = readers,
            books = books,
            categories = categories
        )
    }.flowOn(dispatchersProvider.default())

    private val categoryFlow =
        categoryFeatureRepository.fetchAllCategories().flowOn(dispatchersProvider.io())

    private val booksFlow =
        bookMainScreenFeatureRepository.fetchAllBooks().flowOn(dispatchersProvider.io())

    private val khadissesFlow =
        khadisRepository.fetchAllKhadisses("1").flowOn(dispatchersProvider.io())

    private val surahFlow =
        surahFeatureRepository.fetchAllSurah("1").flowOn(dispatchersProvider.io())

    private val readersFlow =
        readersRepository.fetchAllReaders("1").flowOn(dispatchersProvider.io())

}