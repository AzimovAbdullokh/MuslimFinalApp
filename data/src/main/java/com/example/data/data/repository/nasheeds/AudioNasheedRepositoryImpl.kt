package com.example.data.data.repository.nasheeds

import com.example.data.cache.source.nasheeds.AudioNasheedsCacheDataSource
import com.example.data.cloud.source.nasheeds.AudioNasheedCloudDataSource
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.repositories.AudioNasheedRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class AudioNasheedRepositoryImpl @Inject constructor(
    private val cloudDataSource: AudioNasheedCloudDataSource,
    private val cacheDataSource: AudioNasheedsCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val audioNasheedDataToDomainMapper: Mapper<NasheedsData, NasheedsDomain>,
) : AudioNasheedRepository {

    override fun fetchAllAudioNasheeds(id: String): Flow<List<NasheedsDomain>> =
        flow { emit(cacheDataSource.fetchAllAudioNasheedsFromCacheSingle()) }
            .flatMapLatest { handleFetchNasheedInCache(it, id) }
            .map { audioNasheeds -> audioNasheeds.map(audioNasheedDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())


    override fun fetchAllAudioNasheedsFromCache(): Flow<List<NasheedsDomain>> =
        cacheDataSource.fetchAllAudioNasheedsFromCacheObservable()
            .map { audioNasheeds -> audioNasheeds.map(audioNasheedDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())


    private fun handleFetchNasheedInCache(
        cachedNasheeds: List<NasheedsData>,
        id: String,
    ) = if (cachedNasheeds.isEmpty()) cloudDataSource.fetchAllAudioNasheedsFromCloud(id = id)
        .onEach { nasheedsData ->
            nasheedsData.forEach {
                cacheDataSource.saveNewAudioNasheedsToCache(it)
            }
        }
    else cacheDataSource.fetchAllAudioNasheedsFromCacheObservable()


    override suspend fun fetchAudioNasheedsFromCache(audioNasheedsId: String): NasheedsDomain {
        val audioNasheeds =
            cacheDataSource.fetchAudioNasheedFromId(audioNasheedsId = audioNasheedsId)
        return audioNasheedDataToDomainMapper.map(audioNasheeds)
    }

    override suspend fun clearTable() {
        cacheDataSource.clearTable()
    }


}