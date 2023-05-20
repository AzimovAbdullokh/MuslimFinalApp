package com.example.main_screen.domain.repository

import com.example.main_screen.domain.models.readers.ReadersFeatureMainModel
import kotlinx.coroutines.flow.Flow

interface QuranReadersMainFeatureRepository {

    fun fetchAllReaders(id: String): Flow<List<ReadersFeatureMainModel>>

    fun fetchAllReadersFromCache(): Flow<List<ReadersFeatureMainModel>>

    suspend fun fetchReadersFromCache(readerId: String): ReadersFeatureMainModel

    suspend fun clearTable()
}