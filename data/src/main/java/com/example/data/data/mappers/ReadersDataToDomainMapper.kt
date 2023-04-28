package com.example.data.data.mappers

import com.example.data.data.models.readers.ReadersData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.models.readers.ReaderPosterDomain
import javax.inject.Inject

class ReadersDataToDomainMapper @Inject constructor() : Mapper<ReadersData, ReaderDomain> {
    override fun map(from: ReadersData) = from.run {
        ReaderDomain(id = id,
            readerId = readerId,
            readerName = readerName,
            readerPoster = ReaderPosterDomain(
                name = readerPoster.name,
                url = readerPoster.url,
            ))
    }
}