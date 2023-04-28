package com.example.data.data.repository.khadisses

import com.example.data.cache.source.khadisses.KhadissesCacheDataSource
import com.example.data.cloud.source.khadisses.KhadissesCloudDataSource
import com.example.data.data.models.khadisses.KhadisData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.domain.domain.domain.repositories.KhadisRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class KhadisRepositoryImpl @Inject constructor(
    private val cloudDataSource: KhadissesCloudDataSource,
    private val cacheDataSource: KhadissesCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val khadisDataToDomainMapper: Mapper<KhadisData, KhadisDomain>,
) : KhadisRepository {

    override fun fetchAllKhadisses(id: String): Flow<List<KhadisDomain>> =
        flow { emit(cacheDataSource.fetchAllKhadissesFromCacheSingle()) }
            .flatMapLatest { handleFetchNasheedInCache(it, id) }
            .map { khadis -> khadis.map(khadisDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())


    private fun handleFetchNasheedInCache(
        cashedKhadisses: List<KhadisData>,
        id: String,
    ) = if (cashedKhadisses.isEmpty()) cloudDataSource.fetchAllKhadissesFromCloud(id = id)
        .onEach { khadisData ->
            khadisData.forEach {
                cacheDataSource.saveNewKhadisToCache(it)
            }
        }
    else cacheDataSource.fetchAllKhadissesFromCacheObservable()


    override fun fetchAllKhadissesFromCache(): Flow<List<KhadisDomain>> =
        cacheDataSource.fetchAllKhadissesFromCacheObservable()
            .map { khadisses -> khadisses.map(khadisDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())


    override suspend fun fetcKhadissesFromCache(khadisId: String): KhadisDomain {
        val khadisses =
            cacheDataSource.fetchKhadissesFromId(khadisId = khadisId)
        return khadisDataToDomainMapper.map(khadisses)
    }

    override suspend fun clearTable() {
        cacheDataSource.clearTable()
    }
}