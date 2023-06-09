package com.example.muslimfinalapp.app.glue.audio_screen.mapper

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.alarms.domain.models.readers.ReaderFeaturePoster
import com.example.alarms.domain.models.readers.ReadersFeatureModel
import javax.inject.Inject

class ReaderDomainToFeatureModelMapper @Inject constructor():Mapper<ReaderDomain, ReadersFeatureModel> {
    override fun map(from: ReaderDomain) = from.run {
        ReadersFeatureModel(
            id = id,
            readerId = readerId,
            readerName = readerName,
            readerPoster = ReaderFeaturePoster(name = readerPoster.name, url = readerPoster.url)
        )
    }
}