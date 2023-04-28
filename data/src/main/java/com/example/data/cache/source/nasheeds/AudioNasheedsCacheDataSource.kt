package com.example.data.cache.source.nasheeds

import com.example.data.data.models.nasheeds.NasheedsData
import kotlinx.coroutines.flow.Flow

interface AudioNasheedsCacheDataSource {

    fun fetchAllAudioNasheedsFromCacheObservable() : Flow<List<NasheedsData>>

    suspend fun fetchAllAudioNasheedsFromCacheSingle(): List<NasheedsData>

    suspend fun saveNewAudioNasheedsToCache(audioNasheeds: NasheedsData)

    suspend fun fetchAudioNasheedFromId(audioNasheedsId: String): NasheedsData

    suspend fun clearTable()

}