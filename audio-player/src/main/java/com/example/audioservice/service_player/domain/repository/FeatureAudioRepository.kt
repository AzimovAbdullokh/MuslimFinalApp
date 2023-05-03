package com.example.audioservice.service_player.domain.repository

import com.example.audioservice.service_player.domain.models.NasheedsFeatureModel
import kotlinx.coroutines.flow.Flow

interface FeatureAudioRepository {

    fun fetchAllAudioNasheeds(id: String): Flow<List<NasheedsFeatureModel>>

    fun fetchAllAudioNasheedsFromCache(): Flow<List<NasheedsFeatureModel>>

    fun fetchAudioNasheedFromCacheObservable(audioBookId: String): Flow<NasheedsFeatureModel>

    suspend fun fetchAudioNasheedsFromCache(audioNasheedsId: String): NasheedsFeatureModel

    suspend fun clearTable()
}