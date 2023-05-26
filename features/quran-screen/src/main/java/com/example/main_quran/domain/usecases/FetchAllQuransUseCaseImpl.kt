package com.example.main_quran.domain.usecases

import com.example.common_api.DispatchersProviderInCommonApi
import com.example.main_quran.domain.models.MainQuranItems
import com.example.main_quran.domain.repository.QuranFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchAllQuransUseCaseImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProviderInCommonApi,
    quranFeatureRepository: QuranFeatureRepository,
) : FetchAllQuransUseCase {

    override fun invoke(): Flow<MainQuranItems> = combine(
        quranFlow,
        quranFlow2
    ) { qurans, quran ->
        MainQuranItems(
            qurans = qurans
        )
    }.flowOn(dispatchersProvider.default())

    private val quranFlow =
        quranFeatureRepository.fetchAllSurah("1").flowOn(dispatchersProvider.io())

    private val quranFlow2 =
        quranFeatureRepository.fetchAllSurah("1").flowOn(dispatchersProvider.io())
}