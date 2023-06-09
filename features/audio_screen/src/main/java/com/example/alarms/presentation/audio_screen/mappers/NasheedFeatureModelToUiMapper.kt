package com.example.alarms.presentation.audio_screen.mappers

import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.presentation.audio_screen.models.AudioNasheedsUi
import com.example.alarms.presentation.audio_screen.models.NasheedFileUi
import com.example.alarms.presentation.audio_screen.models.NasheedPosterUi
import com.example.common_api.Mapper
import javax.inject.Inject

class NasheedFeatureModelToUiMapper @Inject constructor():Mapper<NasheedsFeatureModel, AudioNasheedsUi> {
    override fun map(from: NasheedsFeatureModel) = from.run {
        AudioNasheedsUi(
            id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = NasheedFileUi(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = NasheedPosterUi(name = nasheedPoster.name, url = nasheedPoster.url),
            audioId = audioId,
            currentStartPosition = currentStartPosition
        )
    }
}