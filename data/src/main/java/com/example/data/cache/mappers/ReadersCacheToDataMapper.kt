package com.example.data.cache.mappers

import com.example.data.cache.models.ReaderPosterCache
import com.example.data.cache.models.ReadersCache
import com.example.data.data.models.readers.ReaderPosterData
import com.example.data.data.models.readers.ReadersData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class ReadersCacheToDataMapper @Inject constructor() : Mapper<ReadersCache, ReadersData> {
    override fun map(from: ReadersCache) = from.run {
        ReadersData(
            id = id,
            readerId = readerId,
            readerName = name,
            readerPoster = ReaderPosterData(
                name = readerPoster.name,
                url = readerPoster.url,
            )
        )
    }
}

class ReadersDataToCacheMapper @Inject constructor() : Mapper<ReadersData, ReadersCache> {
    override fun map(from: ReadersData) = from.run {
        ReadersCache(
            id = id,
            readerId = readerId,
            name = readerName,
            readerPoster = ReaderPosterCache(
                name = readerPoster.name,
                url = readerPoster.url,
            )
        )
    }
}