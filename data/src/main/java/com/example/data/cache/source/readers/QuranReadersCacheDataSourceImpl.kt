package com.example.data.cache.source.readers

import com.example.data.cache.db.ReaderDao
import com.example.data.cache.models.ReadersCache
import com.example.data.data.models.readers.ReadersData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuranReadersCacheDataSourceImpl @Inject constructor(
    private val dao: ReaderDao,
    private val dispatchersProvider: DispatchersProvider,
    private val readersCacheToDataMapper: Mapper<ReadersCache, ReadersData>,
    private val readersDataToCacheMapper: Mapper<ReadersData, ReadersCache>,
) : QuranReadersCacheDataSource {

    override fun fetchAllReadersFromCacheObservable(): Flow<List<ReadersData>> =
        dao.fetchAllReadersObservable()
            .flowOn(dispatchersProvider.io())
            .map { readers -> readers.map(readersCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchAllReadersFromCacheSingle(): List<ReadersData> =
        dao.fetchAllReadersSingle().map(readersCacheToDataMapper::map)

    override suspend fun saveNewReadersToCache(readers: ReadersData) =
        dao.addNewReaders(reader = readersDataToCacheMapper.map(readers))

    override suspend fun fetchReadersFromId(readerId: String): ReadersData {
        val readers = dao.fetchReadersFromId(readerId)
        return readersCacheToDataMapper.map(readers)
    }

    override suspend fun clearTable() {
        dao.clearTable()
    }
}