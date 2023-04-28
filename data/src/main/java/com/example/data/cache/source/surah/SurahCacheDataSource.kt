package com.example.data.cache.source.surah

import com.example.data.cache.models.SurahCache
import com.example.data.data.models.surah.SurahData
import kotlinx.coroutines.flow.Flow

interface SurahCacheDataSource {

    fun fetchAllSurahFromCacheObservable(): Flow<List<SurahData>>

    fun fetchSurahObservable(surahId: String): Flow<SurahCache?>

    suspend fun fetchAllSurahFromCacheSingle(): List<SurahData>

    suspend fun saveNewSurahToCache(surah: SurahData)

    suspend fun fetchSurahFromId(surahId: String): SurahData

    suspend fun clearTable()
}