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
//    audioNasheedRepository: AudioNasheedFeatureRepository,
    khadisRepository: KhadisFeatureRepository,
    surahFeatureRepository: SurahFeatureRepository,
) : FetchAllMainScreenItemsFeatureUseCase {

    override fun invoke(): Flow<MainScreenFeatureModuleItems> = combine(
        khadissesFlow,
        surahFlow
    ) { khadisses, surah ->
        MainScreenFeatureModuleItems(
//            audioNasheeds = savedBooks,
            khadisses = khadisses,
            surah = surah
        )
    }.flowOn(dispatchersProvider.default())


//    private val nasheedsFlow =
//        audioNasheedRepository.fetchAllAudioNasheeds("38").flowOn(dispatchersProvider.io())

    private val khadissesFlow =
        khadisRepository.fetchAllKhadisses("1").flowOn(dispatchersProvider.io())


    private val surahFlow =
        surahFeatureRepository.fetchAllSurah("1").flowOn(dispatchersProvider.io())


}