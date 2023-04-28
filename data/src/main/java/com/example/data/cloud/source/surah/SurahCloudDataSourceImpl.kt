package com.example.data.cloud.source.surah

import com.example.data.base.ResponseHandler
import com.example.data.cloud.CloudDataRequestState
import com.example.data.cloud.mappers.SurahCloudDataMapper
import com.example.data.cloud.models.surah.SurahCloud
import com.example.data.cloud.models.surah.SurahResponseCloud
import com.example.data.cloud.service.QuranService
import com.example.data.data.models.surah.SurahData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SurahCloudDataSourceImpl @Inject constructor(
    private val service: QuranService,
    private val dispatchersProvider: DispatchersProvider,
    private val surahCloudDataMapper: SurahCloudDataMapper,
    private val responseHandler: ResponseHandler,
    private val surahCloudToDataMapper: Mapper<SurahResponseCloud, SurahCloud>,
) : SurahCloudDataSource {

    override fun fetchAllSurahFromCloud(id: String): Flow<List<SurahData>> =
        flow { emit(service.fetchAllSurah(id = "{\"surahId\":\"${id}\"}")) }
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: SurahResponseCloud(emptyList()) }
            .map { it.surah }
            .map { surah -> surah.map { surahCloudDataMapper.map(it) } }
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchSurahById(surahId: String): CloudDataRequestState<SurahData> =
        responseHandler.safeApiCall { service.fetchAllSurah(id = "{\"objectId\":\"${surahId}\"}") }
            .map(surahCloudToDataMapper)
            .map(surahCloudDataMapper.map())
}