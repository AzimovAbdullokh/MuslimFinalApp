package com.example.data.cloud.source.readers

import com.example.data.data.models.readers.ReadersData
import kotlinx.coroutines.flow.Flow

interface QuranReadersCloudDataSource {

    fun fetchAllQuranReadersFromCloud(id: String): Flow<List<ReadersData>>
}