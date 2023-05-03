package com.example.muslimfinalapp.app.glue.audioservice.gluing_repository

import com.example.audioservice.service_player.domain.repository.FeatureAudioRepository
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.repositories.AudioNasheedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterFeatureAudioNasheedRepository @Inject constructor(
    private val audioNasheedRepository: AudioNasheedRepository,
    private val nasheedsDomainToFeatureModelMapper: Mapper<NasheedsDomain, com.example.audioservice.service_player.domain.models.NasheedsFeatureModel>,
) : FeatureAudioRepository {

    override fun fetchAllAudioNasheeds(id: String): Flow<List<com.example.audioservice.service_player.domain.models.NasheedsFeatureModel>> =
        audioNasheedRepository.fetchAllAudioNasheeds(id = id)
            .map { nasheed -> nasheed.map(nasheedsDomainToFeatureModelMapper::map) }

    override fun fetchAllAudioNasheedsFromCache(): Flow<List<com.example.audioservice.service_player.domain.models.NasheedsFeatureModel>> =
        audioNasheedRepository.fetchAllAudioNasheedsFromCache()
            .map { nasheed -> nasheed.map(nasheedsDomainToFeatureModelMapper::map) }


    override fun fetchAudioNasheedFromCacheObservable(audioBookId: String): Flow<com.example.audioservice.service_player.domain.models.NasheedsFeatureModel> =
        audioNasheedRepository.fetchAudioNasheedFromCacheObservable(audioBookId = audioBookId)
            .map(nasheedsDomainToFeatureModelMapper::map)

    override suspend fun fetchAudioNasheedsFromCache(audioNasheedsId: String): com.example.audioservice.service_player.domain.models.NasheedsFeatureModel {
        val nasheeds =
            audioNasheedRepository.fetchAudioNasheedsFromCache(audioNasheedsId = audioNasheedsId)
        return nasheedsDomainToFeatureModelMapper.map(nasheeds)
    }

    override suspend fun clearTable() {
        audioNasheedRepository.clearTable()
    }
}