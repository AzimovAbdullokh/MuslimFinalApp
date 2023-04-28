package com.example.data.cloud.source.khadisses

import com.example.data.cloud.models.khadisses.KhadisCloud
import com.example.data.cloud.models.khadisses.KhadisResponseCloud
import com.example.data.cloud.service.KhadisService
import com.example.data.data.models.khadisses.KhadisData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class KhadissesCloudDataSourceImpl @Inject constructor(
    private val service:KhadisService,
    private var dispatchersProvider: DispatchersProvider,
    private val khadisCloudToDataMapper:Mapper<KhadisCloud, KhadisData>
    ) : KhadissesCloudDataSource {

    override fun fetchAllKhadissesFromCloud(id: String): Flow<List<KhadisData>> =
        flow { emit(service.fetchAllKhadisses(id = "{\"khadisId\":\"${id}\"}")) }
            .flowOn(dispatchersProvider.io())
            .map { it.body()?:KhadisResponseCloud(emptyList()) }
            .map { it.khadisses }
            .map { khadisses -> khadisses.map(khadisCloudToDataMapper::map) }
            .flowOn(dispatchersProvider.default())
}