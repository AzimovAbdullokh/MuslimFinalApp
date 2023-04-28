package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories

import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.domain.domain.domain.repositories.SurahRepository
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import com.example.main_screen.domain.repository.SurahFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterSurahFeatureRepository @Inject constructor(
    private val surahRepository: SurahRepository,
    private val dispatchersProvider: DispatchersProvider,
    private val surahDomainToSurahFeatureModelMapper: Mapper<SurahDomain, SurahFeatureModuleDomainModel>,
) : SurahFeatureRepository {

    override fun fetchAllSurah(id: String): Flow<List<SurahFeatureModuleDomainModel>> =
        surahRepository.fetchAllSurah(id = id)
            .map { surah -> surah
                .map(surahDomainToSurahFeatureModelMapper::map) }
            .flowOn(dispatchersProvider.default())
}