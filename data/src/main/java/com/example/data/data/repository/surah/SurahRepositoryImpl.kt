package com.example.data.data.repository.surah

import com.example.data.cache.models.SurahCache
import com.example.data.cache.source.surah.SurahCacheDataSource
import com.example.data.cloud.source.surah.SurahCloudDataSource
import com.example.data.cloud.takeSuccess
import com.example.data.data.models.surah.SurahData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.domain.domain.domain.repositories.SurahRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SurahRepositoryImpl @Inject constructor(
    private val cloudDataSource: SurahCloudDataSource,
    private val cacheDataSource: SurahCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val surahDataToDomainMapper: Mapper<SurahData, SurahDomain>,
    private val surahCacheMapper: Mapper<SurahCache, SurahData>,
) : SurahRepository {

    override fun fetchAllSurah(id: String): Flow<List<SurahDomain>> =
        flow { emit(cacheDataSource.fetchAllSurahFromCacheSingle()) }
            .flatMapLatest { handleFetchBookInCache(it, id) }
            .map { surah -> surah.map(surahDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    private fun handleFetchBookInCache(
        cashedSurah: List<SurahData>,
        id: String,
    ) = if (cashedSurah.isEmpty()) cloudDataSource.fetchAllSurahFromCloud(id = id)
        .onEach { surahData ->
            surahData.forEach {
                cacheDataSource.saveNewSurahToCache(it)
            }
        }
    else cacheDataSource.fetchAllSurahFromCacheObservable()


    override fun fetchAllSurahFromCache(): Flow<List<SurahDomain>> =
        cacheDataSource.fetchAllSurahFromCacheObservable()
            .map { surah -> surah.map(surahDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    override fun fetchSurahObservable(surahId: String): Flow<SurahDomain> =
        cacheDataSource.fetchSurahObservable(surahId = surahId).map { surahFromCache ->
            if (surahFromCache == null) cloudDataSource.fetchSurahById(surahId).takeSuccess()
            else surahCacheMapper.map(surahFromCache) }
            .map { it ?: SurahData.unknown }
            .map(surahDataToDomainMapper::map)
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchSurahFromCacheById(surahId: String): SurahDomain {
        val surah = cacheDataSource.fetchSurahFromId(surahId = surahId)
        return surahDataToDomainMapper.map(surah)
    }

    override suspend fun clearTable() {
        cacheDataSource.clearTable()
    }
}