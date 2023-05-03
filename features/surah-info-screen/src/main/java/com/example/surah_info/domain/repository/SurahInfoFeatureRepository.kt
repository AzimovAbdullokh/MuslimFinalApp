package com.example.surah_info.domain.repository

import com.example.surah_info.domain.models.SurahInfoFeatureModuleDomainModel
import kotlinx.coroutines.flow.Flow

interface SurahInfoFeatureRepository {

    fun fetchAllSurah(id: String): Flow<List<SurahInfoFeatureModuleDomainModel>>

    fun fetchBookObservable(surahId: String): Flow<SurahInfoFeatureModuleDomainModel>


}