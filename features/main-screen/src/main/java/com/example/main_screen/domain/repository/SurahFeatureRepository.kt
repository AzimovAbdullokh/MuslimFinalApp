package com.example.main_screen.domain.repository

import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import kotlinx.coroutines.flow.Flow

interface SurahFeatureRepository {

    fun fetchAllSurah(id: String): Flow<List<SurahFeatureModuleDomainModel>>
}