package com.example.muslimfinalapp.app.glue.audio_screen.gluing_repository

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.repositories.AudioNasheedRepository
import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.domain.repository.AudioNasheedFeatureRepository
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
}