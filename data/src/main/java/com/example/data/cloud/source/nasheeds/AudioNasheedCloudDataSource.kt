package com.example.data.cloud.source.nasheeds

import com.example.data.data.models.nasheeds.NasheedsData
import kotlinx.coroutines.flow.Flow

interface AudioNasheedCloudDataSource {

    fun fetchAllAudioNasheedsFromCloud(id:String):Flow<List<NasheedsData>>
}