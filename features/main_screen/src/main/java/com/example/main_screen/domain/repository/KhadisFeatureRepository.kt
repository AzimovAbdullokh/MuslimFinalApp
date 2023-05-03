package com.example.main_screen.domain.repository

import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import kotlinx.coroutines.flow.Flow

interface KhadisFeatureRepository {

    fun fetchAllKhadisses(id: String): Flow<List<KhadisFeatureModel>>

    fun fetchAllKhadissesFromCache(): Flow<List<KhadisFeatureModel>>

    suspend fun fetcKhadissesFromCache(khadisId: String): KhadisFeatureModel

    suspend fun clearTable()
}