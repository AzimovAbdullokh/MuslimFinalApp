package com.example.data.cache.source.surah

import com.example.data.cache.db.SurahDao
import com.example.data.cache.models.SurahCache
import com.example.data.data.models.surah.SurahData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SurahCacheDataSourceImpl @Inject constructor(
    private val dao: SurahDao,
    private val dispatchersProvider: DispatchersProvider,
    private val surahDataToCacheMapper: Mapper<SurahData, SurahCache>,
    private val surahCacheToDataMapper: Mapper<SurahCache, SurahData>,
) : SurahCacheDataSource {

    override fun fetchAllSurahFromCacheObservable(): Flow<List<SurahData>> =
        dao.fetchAllSurahObservable()
            .flowOn(dispatchersProvider.io())
            .map { surah -> surah.map(surahCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override fun fetchSurahObservable(surahId: String): Flow<SurahCache?> =
        dao.fetchSurahObservable(surahId = surahId)
            .flowOn(dispatchersProvider.io())

    override suspend fun fetchAllSurahFromCacheSingle(): List<SurahData> =
        dao.fetchAllSurahSingle().map(surahCacheToDataMapper::map)

    override suspend fun saveNewSurahToCache(surah: SurahData) =
        dao.addNewSurah(surah = surahDataToCacheMapper.map(surah))

    override suspend fun fetchSurahFromId(surahId: String): SurahData {
        val surah = dao.fetchSurahFromId(surahId = surahId)
        return surahCacheToDataMapper.map(surah)
    }

    override suspend fun clearTable() {
        dao.clearTable()
    }
}