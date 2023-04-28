package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import kotlinx.coroutines.flow.Flow

interface KhadisRepository {

    fun fetchAllKhadisses(id: String): Flow<List<KhadisDomain>>

    fun fetchAllKhadissesFromCache(): Flow<List<KhadisDomain>>

    suspend fun fetcKhadissesFromCache(khadisId: String): KhadisDomain

    suspend fun clearTable()
}