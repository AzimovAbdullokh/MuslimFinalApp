package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.repositories.AudioNasheedRepository
import com.example.main_screen.domain.models.nasheeds.NasheedsFeatureModel
import com.example.main_screen.domain.repository.AudioNasheedFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterNasheedsFeatureRepository @Inject constructor(
    private val audioNasheedRepository: AudioNasheedRepository,
    private val nasheedsDomainToFeatureModelMapper: Mapper<NasheedsDomain, NasheedsFeatureModel>,
) : AudioNasheedFeatureRepository {

    override fun fetchAllAudioNasheeds(id: String): Flow<List<NasheedsFeatureModel>> =
        audioNasheedRepository.fetchAllAudioNasheeds(id = id).map { nasheeds ->
            nasheeds.map(nasheedsDomainToFeatureModelMapper::map)
        }

    override fun fetchAllAudioNasheedsFromCache(): Flow<List<NasheedsFeatureModel>> =
        audioNasheedRepository.fetchAllAudioNasheedsFromCache().map { nasheeds ->
            nasheeds.map(nasheedsDomainToFeatureModelMapper::map)
        }

    override suspend fun fetchAudioNasheedsFromCache(audioNasheedsId: String): NasheedsFeatureModel {
        val nasheeds = audioNasheedRepository.fetchAudioNasheedsFromCache(audioNasheedsId = audioNasheedsId)
        return nasheedsDomainToFeatureModelMapper.map(nasheeds)
    }

    override suspend fun clearTable() {
        audioNasheedRepository.clearTable()
    }
}