package com.example.data.cache.source.nasheeds

import com.example.data.cache.db.AudioNasheedsDao
import com.example.data.cache.models.AudioNasheedsCashe
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AudioNasheedsCacheDataSourceImpl @Inject constructor(
    private val dao:AudioNasheedsDao,
    private val dispatchersProvider: DispatchersProvider,
    private val audioNasheedsCacheToDataMapper: Mapper<AudioNasheedsCashe, NasheedsData>,
    private val audioNasheedDataToCacheMapper: Mapper<NasheedsData, AudioNasheedsCashe>
) : AudioNasheedsCacheDataSource {


    override fun fetchAllAudioNasheedsFromCacheObservable(): Flow<List<NasheedsData>> =
        dao.fetchAllAudioNasheedsObservable()
            .flowOn(dispatchersProvider.io())
            .map { nasheeds -> nasheeds.map(audioNasheedsCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())


    override suspend fun fetchAllAudioNasheedsFromCacheSingle(): List<NasheedsData> =
        dao.fetchAllAudioNasheedsSingle().map(audioNasheedsCacheToDataMapper::map)


    override suspend fun saveNewAudioNasheedsToCache(audioNasheeds: NasheedsData) =
        dao.addNewNasheed(audioNasheed = audioNasheedDataToCacheMapper.map(audioNasheeds))

    override suspend fun fetchAudioNasheedFromId(audioNasheedsId: String): NasheedsData {
       val audioNasheed = dao.fetchAudioNasheedsFromId(audioNasheedsId)
        return audioNasheedsCacheToDataMapper.map(audioNasheed)
    }

    override suspend fun clearTable() {
        dao.clearTable()
    }
}