package com.example.names_screen.domain.repository

import com.example.names_screen.domain.models.NamesFeatureDomain
import kotlinx.coroutines.flow.Flow

interface AllahNamesFeatureRepository {

    fun fetchAllNames(): Flow<List<NamesFeatureDomain>>

    fun fetchAllNamesFromCache(): Flow<List<NamesFeatureDomain>>

    suspend fun clearTable()
}