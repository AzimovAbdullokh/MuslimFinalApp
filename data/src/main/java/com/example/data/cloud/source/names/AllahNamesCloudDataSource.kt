package com.example.data.cloud.source.names

import com.example.data.cloud.models.names.NamesCloud
import com.example.data.data.models.names.NamesData
import kotlinx.coroutines.flow.Flow

interface AllahNamesCloudDataSource {

    fun fetchAllNamesFromCloud(): Flow<List<NamesData>>
}