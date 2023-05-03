package com.example.main_quran.domain.repository

import com.example.main_quran.domain.models.QuranFeatureModuleDomainModel
import kotlinx.coroutines.flow.Flow

interface QuranFeatureRepository {

    fun fetchAllSurah(id: String): Flow<List<QuranFeatureModuleDomainModel>>

}