package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.nasheeds.NasheedsFeatureModel
import com.example.main_screen.presentation.models.AudioNasheedsUi
import com.example.main_screen.presentation.models.NasheedFileUi
import com.example.main_screen.presentation.models.NasheedPosterUi
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