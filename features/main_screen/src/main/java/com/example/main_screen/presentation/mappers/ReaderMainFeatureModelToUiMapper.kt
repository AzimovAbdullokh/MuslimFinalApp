package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.readers.ReadersFeatureMainModel
import com.example.main_screen.presentation.models.ReaderPosterFeatureMainModelUi
import com.example.main_screen.presentation.models.ReadersFeatureMainUiModel
import javax.inject.Inject

class ReaderMainFeatureModelToUiMapper @Inject constructor() :
    Mapper<ReadersFeatureMainModel, ReadersFeatureMainUiModel> {
    override fun map(from: ReadersFeatureMainModel) = from.run {
        ReadersFeatureMainUiModel(
            id = id,
            readerId = readerId,
            readerName = readerName,
            readerPoster = ReaderPosterFeatureMainModelUi(name = readerPoster.name,
                url = readerPoster.url)
        )
    }
}