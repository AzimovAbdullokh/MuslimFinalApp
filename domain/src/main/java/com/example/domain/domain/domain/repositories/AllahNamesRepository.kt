package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.names.NamesDomain
import kotlinx.coroutines.flow.Flow

interface AllahNamesRepository {

    fun fetchAllNames(): Flow<List<NamesDomain>>

    fun fetchAllNamesFromCache(): Flow<List<NamesDomain>>

    suspend fun clearTable()
}