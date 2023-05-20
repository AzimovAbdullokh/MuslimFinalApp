package com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.main_screen.domain.models.readers.ReaderFeatureMainPoster
import com.example.main_screen.domain.models.readers.ReadersFeatureMainModel
import javax.inject.Inject

class ReaderDomainToMainFeatureModelMapper @Inject constructor():Mapper<ReaderDomain, ReadersFeatureMainModel> {
    override fun map(from: ReaderDomain) = from.run {
        ReadersFeatureMainModel(
            id = id,
            readerId = readerId,
            readerName = readerName,
            readerPoster = ReaderFeatureMainPoster(name = readerPoster.name, url = readerPoster.url)
        )
    }
}