package com.example.data.cache.source.name

import com.example.data.data.models.names.NamesData
import kotlinx.coroutines.flow.Flow

interface AllahNamesCacheDataSource {

    fun fetchAllNamesFromCacheObservable() : Flow<List<NamesData>>

   suspend fun fetchAllNamesFromCacheSingle() : List<NamesData>

    suspend fun saveNewNameToCache(names: NamesData)

    suspend fun clearTable()

}