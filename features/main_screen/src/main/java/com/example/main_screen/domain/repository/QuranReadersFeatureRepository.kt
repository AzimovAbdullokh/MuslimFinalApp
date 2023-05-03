package com.example.main_screen.domain.repository

import com.example.main_screen.domain.models.readers.ReadersFeatureModel
import kotlinx.coroutines.flow.Flow

interface QuranReadersFeatureRepository {

    fun fetchAllReaders(id: String): Flow<List<ReadersFeatureModel>>

    fun fetchAllReadersFromCache(): Flow<List<ReadersFeatureModel>>

    suspend fun fetchReadersFromCache(readerId: String): ReadersFeatureModel

    suspend fun clearTable()
}