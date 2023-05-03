package com.example.alarms.domain.repository

import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import kotlinx.coroutines.flow.Flow

interface AudioNasheedFeatureRepository {

    fun fetchAllAudioNasheeds(id: String): Flow<List<NasheedsFeatureModel>>

    fun fetchAllAudioNasheedsFromCache(): Flow<List<NasheedsFeatureModel>>

    suspend fun fetchAudioNasheedsFromCache(audioNasheedsId: String): NasheedsFeatureModel

    suspend fun clearTable()

}