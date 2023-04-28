package com.example.data.cloud.source.khadisses

import com.example.data.data.models.khadisses.KhadisData
import kotlinx.coroutines.flow.Flow

interface KhadissesCloudDataSource {

    fun fetchAllKhadissesFromCloud(id: String): Flow<List<KhadisData>>
}