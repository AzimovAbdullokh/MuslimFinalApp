package com.example.data.cache.source.readers

import com.example.data.data.models.readers.ReadersData
import kotlinx.coroutines.flow.Flow

interface QuranReadersCacheDataSource {

    fun fetchAllReadersFromCacheObservable(): Flow<List<ReadersData>>

    suspend fun fetchAllReadersFromCacheSingle(): List<ReadersData>

    suspend fun saveNewReadersToCache(readers: ReadersData)

    suspend fun fetchReadersFromId(readerId: String): ReadersData

    suspend fun clearTable()
}