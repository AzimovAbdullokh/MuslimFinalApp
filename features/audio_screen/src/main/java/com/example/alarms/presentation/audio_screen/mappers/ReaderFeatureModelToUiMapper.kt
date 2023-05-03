package com.example.alarms.presentation.audio_screen.mappers

import com.example.alarms.presentation.audio_screen.models.ReaderPosterFeatureModelUi
import com.example.alarms.presentation.audio_screen.models.ReadersFeatureUiModel
import com.example.common_api.Mapper
import com.example.alarms.domain.models.readers.ReadersFeatureModel
import javax.inject.Inject

class ReaderFeatureModelToUiMapper @Inject constructor():Mapper<ReadersFeatureModel, ReadersFeatureUiModel> {
    override fun map(from: ReadersFeatureModel) = from.run {
        ReadersFeatureUiModel(
            id = id,
            readerId = readerId,
            readerName = readerName,
            readerPoster = ReaderPosterFeatureModelUi(name = readerPoster.name, url = readerPoster.url)
        )
    }
}