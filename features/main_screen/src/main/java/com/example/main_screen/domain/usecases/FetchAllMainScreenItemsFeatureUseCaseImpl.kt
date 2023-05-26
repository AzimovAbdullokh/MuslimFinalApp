package com.example.main_screen.domain.usecases

import com.example.common_api.DispatchersProviderInCommonApi
import com.example.main_screen.domain.models.MainScreenFeatureModuleItems
import com.example.main_screen.domain.repository.KhadisFeatureRepository
import com.example.main_screen.domain.repository.QuranReadersMainFeatureRepository
import com.example.main_screen.domain.repository.SurahFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchAllMainScreenItemsFeatureUseCaseImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProviderInCommonApi,
//    audioNasheedRepository: AudioNasheedFeatureRepository,
    khadisRepository: KhadisFeatureRepository,
    surahFeatureRepository: SurahFeatureRepository,
    readersRepository: QuranReadersMainFeatureRepository,
) : FetchAllMainScreenItemsFeatureUseCase {

    override fun invoke(): Flow<MainScreenFeatureModuleItems> = combine(
        khadissesFlow,
        surahFlow,
        readersFlow
    ) { khadisses, surah, readers ->
        MainScreenFeatureModuleItems(
//            audioNasheeds = savedBooks,
            khadisses = khadisses,
            surah = surah,
            readers = readers
        )
    }.flowOn(dispatchersProvider.default())


//    private val nasheedsFlow =
//        audioNasheedRepository.fetchAllAudioNasheeds("38").flowOn(dispatchersProvider.io())

    private val khadissesFlow =
        khadisRepository.fetchAllKhadisses("1").flowOn(dispatchersProvider.io())


    private val surahFlow =
        surahFeatureRepository.fetchAllSurah("1").flowOn(dispatchersProvider.io())

    private val readersFlow =
        readersRepository.fetchAllReaders("1").flowOn(dispatchersProvider.io())

}