package com.example.data.cloud.source.nasheeds

import com.example.data.cloud.models.nasheeds.NasheedsCloud
import com.example.data.cloud.models.nasheeds.NasheedsResponseCloud
import com.example.data.cloud.service.NasheedsService
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AudioNasheedCloudDataSourceImpl @Inject constructor(
    private var service: NasheedsService,
    private var dispatchersProvider: DispatchersProvider,
    private var nasheedCloudToDataMapper: Mapper<NasheedsCloud, NasheedsData>,
) : AudioNasheedCloudDataSource {

    override fun fetchAllAudioNasheedsFromCloud(id: String): Flow<List<NasheedsData>> =
        flow { emit(service.fetchAllNasheeds(id = "{\"audioId\":\"${id}\"}"))}
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: NasheedsResponseCloud(emptyList()) }
            .map { it.nasheeds }
            .map { nasheeds -> nasheeds.map(nasheedCloudToDataMapper::map) }
            .flowOn(dispatchersProvider.default())
}