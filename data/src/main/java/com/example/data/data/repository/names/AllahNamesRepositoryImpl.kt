package com.example.data.data.repository.names

import com.example.data.cache.source.name.AllahNamesCacheDataSource
import com.example.data.cloud.source.names.AllahNamesCloudDataSource
import com.example.data.data.models.names.NamesData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.names.NamesDomain
import com.example.domain.domain.domain.repositories.AllahNamesRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class AllahNamesRepositoryImpl @Inject constructor(
    private val cloudDataSource: AllahNamesCloudDataSource,
    private val cacheDataSource: AllahNamesCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val namesDataToDomainMapper: Mapper<NamesData, NamesDomain>,
) : AllahNamesRepository {

    override fun fetchAllNames(): Flow<List<NamesDomain>> =
        flow { emit(cacheDataSource.fetchAllNamesFromCacheSingle()) }
            .flatMapLatest { handleFetchNamesInCache(it) }
            .map { names -> names.map(namesDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    private fun handleFetchNamesInCache(
        cachedNames: List<NamesData>,
    ) = if (cachedNames.isEmpty())
        cloudDataSource.fetchAllNamesFromCloud()
            .onEach { namesData ->
                namesData.forEach { cacheDataSource.saveNewNameToCache(it) }
            }
    else cacheDataSource.fetchAllNamesFromCacheObservable()


    override fun fetchAllNamesFromCache(): Flow<List<NamesDomain>> =
        cacheDataSource.fetchAllNamesFromCacheObservable()
            .map { names -> names.map(namesDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    override suspend fun clearTable() = cacheDataSource.clearTable()

}