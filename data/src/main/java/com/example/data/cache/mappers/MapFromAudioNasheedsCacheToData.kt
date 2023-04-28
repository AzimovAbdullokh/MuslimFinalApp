package com.example.data.cache.mappers

import com.example.data.cache.models.AudioNasheedsCashe
import com.example.data.data.models.nasheeds.NasheedFileData
import com.example.data.data.models.nasheeds.NasheedPosterData
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromAudioNasheedsCacheToData @Inject constructor() :
    Mapper<AudioNasheedsCashe, NasheedsData> {

    override fun map(from: AudioNasheedsCashe) = from.run {
        NasheedsData(
            id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = NasheedFileData(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = NasheedPosterData(name = nasheedPoster.name, url = nasheedPoster.url),
            audioId = audioId
        )
    }
}