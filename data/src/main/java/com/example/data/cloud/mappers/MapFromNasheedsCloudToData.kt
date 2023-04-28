package com.example.data.cloud.mappers

import com.example.data.cloud.models.nasheeds.NasheedsCloud
import com.example.data.data.models.nasheeds.NasheedFileData
import com.example.data.data.models.nasheeds.NasheedPosterData
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromNasheedsCloudToData @Inject constructor() : Mapper<NasheedsCloud, NasheedsData> {
    override fun map(from: NasheedsCloud) = from.run {
        NasheedsData(id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = NasheedFileData(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = NasheedPosterData(name = nasheedPoster.name, url = nasheedPoster.url),
            audioId = audioId)
    }
}