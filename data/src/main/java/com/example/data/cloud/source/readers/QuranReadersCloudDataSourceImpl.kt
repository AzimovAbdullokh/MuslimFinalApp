package com.example.data.cloud.source.readers

import com.example.data.cloud.models.readers.ReadersCloud
import com.example.data.cloud.models.readers.ReadersResponse
import com.example.data.cloud.service.ReadersService
import com.example.data.data.models.readers.ReadersData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuranReadersCloudDataSourceImpl @Inject constructor(
    private val service: ReadersService,
    private val dispatchersProvider: DispatchersProvider,
    private val readersCloudToDataMapper:Mapper<ReadersCloud, ReadersData>
) : QuranReadersCloudDataSource {

    override fun fetchAllQuranReadersFromCloud(id: String): Flow<List<ReadersData>> =
        flow { emit(service.fetchAllReaders(id = "{\"readerId\":\"${id}\"}")) }
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: ReadersResponse(emptyList()) }
            .map { it.readers }
            .map { readers -> readers.map(readersCloudToDataMapper::map) }
            .flowOn(dispatchersProvider.default())
}