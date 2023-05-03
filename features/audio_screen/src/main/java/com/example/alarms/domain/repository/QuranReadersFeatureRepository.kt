package com.example.alarms.domain.repository

import com.example.alarms.domain.models.readers.ReadersFeatureModel
import kotlinx.coroutines.flow.Flow

interface QuranReadersFeatureRepository {

    fun fetchAllReaders(id: String): Flow<List<ReadersFeatureModel>>

    fun fetchAllReadersFromCache(): Flow<List<ReadersFeatureModel>>

    suspend fun fetchReadersFromCache(readerId: String): ReadersFeatureModel

    suspend fun clearTable()
}