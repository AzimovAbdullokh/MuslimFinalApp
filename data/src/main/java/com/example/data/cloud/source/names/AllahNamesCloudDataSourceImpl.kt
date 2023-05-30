package com.example.data.cloud.source.names

import com.example.data.cloud.models.names.NamesCloud
import com.example.data.cloud.models.names.NamesResponseCloud
import com.example.data.cloud.service.NamesAllahService
import com.example.data.data.models.names.NamesData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AllahNamesCloudDataSourceImpl @Inject constructor(
    private val service: NamesAllahService,
    private val dispatchersProvider: DispatchersProvider,
    private val namesCloudToDataMapper:Mapper<NamesCloud, NamesData>
) : AllahNamesCloudDataSource {

    override fun fetchAllNamesFromCloud(): Flow<List<NamesData>> =
        flow { emit(service.fetchAllNames()) }
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: NamesResponseCloud(emptyList()) }
            .map { it.names }
            .map { names -> names.map(namesCloudToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

}