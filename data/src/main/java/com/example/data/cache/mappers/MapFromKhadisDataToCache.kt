package com.example.data.cache.mappers

import com.example.data.cache.models.KhadissesCache
import com.example.data.cache.models.NamazPosterCache
import com.example.data.data.models.khadisses.KhadisData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromKhadisDataToCache @Inject constructor(): Mapper<KhadisData , KhadissesCache> {
    override fun map(from: KhadisData) = from.run {
        KhadissesCache(
            id = id,
            title = title,
            createdAt = createdAt,
            khadisId =  khadisId,
            khadisDescription = khadisDescription,
            khadisSubject = khadisSubject,
            namazImage = NamazPosterCache(name = namazImage.name, type = namazImage.type, url = namazImage.url)
        )
    }
}