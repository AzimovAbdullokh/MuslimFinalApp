package com.example.data.cloud.mappers

import com.example.data.cloud.models.readers.ReadersCloud
import com.example.data.data.models.readers.ReaderPosterData
import com.example.data.data.models.readers.ReadersData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class ReadersCloudToDataMapper @Inject constructor():Mapper<ReadersCloud, ReadersData> {
    override fun map(from: ReadersCloud) = from.run {
        ReadersData(
            id = id,
            readerId = readerId,
            readerName = readerName,
            readerPoster = ReaderPosterData(name = readerPoster.name, url = readerPoster.url)
        )
    }
}