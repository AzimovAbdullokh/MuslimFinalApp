package com.example.data.cache.source.khadisses

import com.example.data.data.models.khadisses.KhadisData
import kotlinx.coroutines.flow.Flow

interface KhadissesCacheDataSource {

    fun fetchAllKhadissesFromCacheObservable() : Flow<List<KhadisData>>

    suspend fun fetchAllKhadissesFromCacheSingle(): List<KhadisData>

    suspend fun saveNewKhadisToCache(khadisses: KhadisData)

    suspend fun fetchKhadissesFromId(khadisId: String): KhadisData

    suspend fun clearTable()

}