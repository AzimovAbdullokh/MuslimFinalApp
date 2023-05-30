package com.example.data.cache.source.name

import com.example.data.cache.db.NamesDao
import com.example.data.cache.models.NamesCache
import com.example.data.data.models.names.NamesData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AllahNamesCacheDataSourceImpl @Inject constructor(
    private val dao: NamesDao,
    private val dispatchersProvider: DispatchersProvider,
    private val namesDataToCacheMapper: Mapper<NamesData, NamesCache>,
    private val namesCacheToDataMapper: Mapper<NamesCache, NamesData>,
) : AllahNamesCacheDataSource {

    override fun fetchAllNamesFromCacheObservable(): Flow<List<NamesData>> =
        dao.fetchAllNamesObservable()
            .flowOn(dispatchersProvider.io())
            .map { names -> names.map(namesCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchAllNamesFromCacheSingle(): List<NamesData> =
        dao.fetchAllNamesSingle().map(namesCacheToDataMapper::map)

    override suspend fun saveNewNameToCache(names: NamesData) =
        dao.addNewName(name = namesDataToCacheMapper.map(names))


    override suspend fun clearTable() = dao.clearTable()

}