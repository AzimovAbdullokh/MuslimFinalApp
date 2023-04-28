package com.example.data.cache.mappers

import com.example.data.cache.models.AudioNasheedFileCache
import com.example.data.cache.models.AudioNasheedPosterCache
import com.example.data.cache.models.AudioNasheedsCashe
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromNasheedsDataToCache @Inject constructor() : Mapper<NasheedsData, AudioNasheedsCashe> {
    override fun map(from: NasheedsData) = from.run {
        AudioNasheedsCashe(
            id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = AudioNasheedFileCache(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = AudioNasheedPosterCache(name = nasheedPoster.name, nasheedPoster.url),
            audioId = audioId
        )
    }
}