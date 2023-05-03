package com.example.muslimfinalapp.app.glue.audioservice.mapper

import com.example.audioservice.service_player.domain.models.NasheedFeatureFile
import com.example.audioservice.service_player.domain.models.NasheedFeaturePoster
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.audioservice.service_player.domain.models.NasheedsFeatureModel
import javax.inject.Inject

class NasheedsDomainToServiceFeatureModelMapper @Inject constructor() :
    Mapper<NasheedsDomain, NasheedsFeatureModel> {
    override fun map(from: NasheedsDomain) = from.run {
        NasheedsFeatureModel(id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = NasheedFeatureFile(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = NasheedFeaturePoster(name = nasheedPoster.name, url = nasheedPoster.url),
            audioId = audioId,
            currentStartPosition = currentStartPosition)
    }
}