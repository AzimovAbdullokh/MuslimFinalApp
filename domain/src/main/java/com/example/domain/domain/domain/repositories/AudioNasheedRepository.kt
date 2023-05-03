package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import kotlinx.coroutines.flow.Flow

interface AudioNasheedRepository {

    fun fetchAllAudioNasheeds(id: String): Flow<List<NasheedsDomain>>

    fun fetchAllAudioNasheedsFromCache(): Flow<List<NasheedsDomain>>

    fun fetchAudioNasheedFromCacheObservable(audioBookId: String): Flow<NasheedsDomain>

    suspend fun fetchAudioNasheedsFromCache(audioNasheedsId: String): NasheedsDomain

    suspend fun clearTable()

}