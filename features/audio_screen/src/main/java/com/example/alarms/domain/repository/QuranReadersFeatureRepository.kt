package com.example.alarms.domain.repository

import com.example.alarms.domain.models.readers.ReadersFeatureModel
import kotlinx.coroutines.flow.Flow

interface QuranReadersFeatureRepository {

    fun fetchAllReaders(id: String): Flow<List<ReadersFeatureModel>>
}