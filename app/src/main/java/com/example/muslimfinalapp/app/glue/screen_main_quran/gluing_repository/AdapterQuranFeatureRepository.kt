package com.example.muslimfinalapp.app.glue.screen_main_quran.gluing_repository

import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.domain.domain.domain.repositories.SurahRepository
import com.example.main_quran.domain.models.QuranFeatureModuleDomainModel
import com.example.main_quran.domain.repository.QuranFeatureRepository
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import com.example.main_screen.domain.repository.SurahFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterQuranFeatureRepository @Inject constructor(
    private val surahRepository: SurahRepository,
    private val dispatchersProvider: DispatchersProvider,
    private val surahDomainToSurahFeatureModelMapper: Mapper<SurahDomain, QuranFeatureModuleDomainModel>,
) : QuranFeatureRepository {

    override fun fetchAllSurah(id: String): Flow<List<QuranFeatureModuleDomainModel>> =
        surahRepository.fetchAllSurah(id = id)
            .map { surah -> surah
                .map(surahDomainToSurahFeatureModelMapper::map) }
            .flowOn(dispatchersProvider.default())
}