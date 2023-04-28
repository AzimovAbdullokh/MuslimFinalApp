package com.example.data.data.repository.readers

import com.example.data.cache.source.readers.QuranReadersCacheDataSource
import com.example.data.cloud.source.readers.QuranReadersCloudDataSource
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.data.data.models.readers.ReadersData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.repositories.QuranReadersRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class QuranReadersRepositoryImpl @Inject constructor(
    private val cloudDataSource: QuranReadersCloudDataSource,
    private val cacheDataSource: QuranReadersCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val readersDataToDomainMapper: Mapper<ReadersData, ReaderDomain>,
) : QuranReadersRepository {

    override fun fetchAllReaders(id: String): Flow<List<ReaderDomain>> =
        flow { emit(cacheDataSource.fetchAllReadersFromCacheSingle()) }
            .flatMapLatest { handleFetchReadersInCache(it, id) }
            .map { readers -> readers.map(readersDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())


    override fun fetchAllReadersFromCache(): Flow<List<ReaderDomain>> =
        cacheDataSource.fetchAllReadersFromCacheObservable()
            .map { readers -> readers.map(readersDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchReadersFromCache(readerId: String): ReaderDomain {
        val readers = cacheDataSource.fetchReadersFromId(readerId = readerId)
        return readersDataToDomainMapper.map(readers)
    }

    override suspend fun clearTable() {
        cacheDataSource.clearTable()
    }


    private fun handleFetchReadersInCache(
        cachedReaders: List<ReadersData>,
        id: String,
    ) = if (cachedReaders.isEmpty()) cloudDataSource.fetchAllQuranReadersFromCloud(id = id)
        .onEach { readersData ->
            readersData.forEach {
                cacheDataSource.saveNewReadersToCache(it)
            }
        }
    else cacheDataSource.fetchAllReadersFromCacheObservable()
}