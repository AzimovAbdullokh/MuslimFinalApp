package com.example.data.cloud.source.surah

import com.example.data.cloud.CloudDataRequestState
import com.example.data.data.models.surah.SurahData
import kotlinx.coroutines.flow.Flow

interface SurahCloudDataSource {

    fun fetchAllSurahFromCloud(id: String): Flow<List<SurahData>>

    suspend fun fetchSurahById(surahId: String): CloudDataRequestState<SurahData>
}