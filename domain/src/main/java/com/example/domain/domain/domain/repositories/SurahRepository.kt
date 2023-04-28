package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.surah.SurahDomain
import kotlinx.coroutines.flow.Flow

interface SurahRepository {

    fun fetchAllSurah(id: String): Flow<List<SurahDomain>>

    fun fetchAllSurahFromCache(): Flow<List<SurahDomain>>

    fun fetchSurahObservable(surahId: String): Flow<SurahDomain>

    suspend fun fetchSurahFromCacheById(surahId: String): SurahDomain

    suspend fun clearTable()
}