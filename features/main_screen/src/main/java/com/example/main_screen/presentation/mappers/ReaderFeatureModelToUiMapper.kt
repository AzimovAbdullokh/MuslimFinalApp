package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.readers.ReadersFeatureModel
import com.example.main_screen.presentation.models.ReaderPosterFeatureModelUi
import com.example.main_screen.presentation.models.ReadersFeatureUiModel
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