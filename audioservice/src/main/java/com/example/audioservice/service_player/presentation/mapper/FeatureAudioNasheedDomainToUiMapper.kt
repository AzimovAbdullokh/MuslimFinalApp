package com.example.audioservice.service_player.presentation.mapper

import com.example.audioservice.service_player.domain.models.NasheedsFeatureModel
import com.example.audioservice.service_player.presentation.models.AudioNasheedsUi
import com.example.audioservice.service_player.presentation.models.NasheedFileUi
import com.example.audioservice.service_player.presentation.models.NasheedPosterUi
import com.example.common_api.Mapper
import javax.inject.Inject

class FeatureAudioNasheedDomainToUiMapper @Inject constructor() : Mapper<NasheedsFeatureModel, AudioNasheedsUi> {
    override fun map(from: NasheedsFeatureModel) = from.run {
        AudioNasheedsUi(id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = NasheedFileUi(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = NasheedPosterUi(name = nasheedPoster.name, url = nasheedPoster.url),
            audioId = audioId,
            currentStartPosition = currentStartPosition)
    }
}