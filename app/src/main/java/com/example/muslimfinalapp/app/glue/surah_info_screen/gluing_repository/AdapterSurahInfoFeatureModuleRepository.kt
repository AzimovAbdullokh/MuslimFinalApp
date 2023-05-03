package com.example.muslimfinalapp.app.glue.surah_info_screen.gluing_repository

import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.domain.domain.domain.repositories.SurahRepository
import com.example.surah_info.domain.models.SurahInfoFeatureModuleDomainModel
import com.example.surah_info.domain.repository.SurahInfoFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterSurahInfoFeatureModuleRepository @Inject constructor(
    private val surahRepository: SurahRepository,
    private val dispatchersProvider: DispatchersProvider,
    private val surahDomainToSurahFeatureModelMapper: Mapper<SurahDomain, SurahInfoFeatureModuleDomainModel>,
) : SurahInfoFeatureRepository {

    override fun fetchAllSurah(id: String): Flow<List<SurahInfoFeatureModuleDomainModel>> =
        surahRepository.fetchAllSurah(id = id)
            .map { surah -> surah.map(surahDomainToSurahFeatureModelMapper::map) }
            .flowOn(dispatchersProvider.default())

    override fun fetchBookObservable(surahId: String): Flow<SurahInfoFeatureModuleDomainModel> =
        surahRepository.fetchSurahObservable(surahId = surahId)
            .map(surahDomainToSurahFeatureModelMapper::map)
            .flowOn(dispatchersProvider.default())

}