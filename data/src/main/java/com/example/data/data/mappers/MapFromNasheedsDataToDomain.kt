package com.example.data.data.mappers

import com.example.data.data.models.nasheeds.NasheedsData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedFileDomain
import com.example.domain.domain.domain.models.nasheeds.NasheedPosterDomain
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import javax.inject.Inject

class MapFromNasheedsDataToDomain @Inject constructor() : Mapper<NasheedsData, NasheedsDomain> {
    override fun map(from: NasheedsData) = from.run {
        NasheedsDomain(
            id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = NasheedFileDomain(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = NasheedPosterDomain(name = nasheedPoster.name, nasheedPoster.url),
            audioId = audioId,
            currentStartPosition = 0
        )
    }
}