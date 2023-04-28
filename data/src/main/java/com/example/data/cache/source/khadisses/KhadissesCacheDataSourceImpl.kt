package com.example.data.cache.source.khadisses

import com.example.data.cache.db.KhadissesDao
import com.example.data.cache.models.KhadissesCache
import com.example.data.data.models.khadisses.KhadisData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class KhadissesCacheDataSourceImpl @Inject constructor(
    private val dao: KhadissesDao,
    private val dispatchersProvider: DispatchersProvider,
    private val khadisDataToCacheMapper: Mapper<KhadisData, KhadissesCache>,
    private val khadissesCacheToDataMapper: Mapper<KhadissesCache, KhadisData>,
) : KhadissesCacheDataSource {

    override fun fetchAllKhadissesFromCacheObservable(): Flow<List<KhadisData>> =
        dao.fetchAllKhadissesObservable()
            .flowOn(dispatchersProvider.io())
            .map { khadisses -> khadisses.map(khadissesCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchAllKhadissesFromCacheSingle(): List<KhadisData> =
        dao.fetchAllKhadissesSingle().map(khadissesCacheToDataMapper::map)

    override suspend fun saveNewKhadisToCache(khadisses: KhadisData) =
        dao.addNewKhadis(khadis = khadisDataToCacheMapper.map(khadisses))

    override suspend fun fetchKhadissesFromId(khadisId: String): KhadisData {
        val khadis = dao.fetchKhadissesFromId(khadisId)
        return khadissesCacheToDataMapper.map(khadis)
    }


    override suspend fun clearTable() {
        dao.clearTable()
    }
}