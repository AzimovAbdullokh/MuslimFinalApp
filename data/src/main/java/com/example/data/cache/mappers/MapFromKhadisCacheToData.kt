package com.example.data.cache.mappers

import com.example.data.cache.models.KhadissesCache
import com.example.data.data.models.khadisses.KhadisData
import com.example.data.data.models.khadisses.NamazPosterData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromKhadisCacheToData @Inject constructor():Mapper<KhadissesCache, KhadisData> {
    override fun map(from: KhadissesCache) = from.run {
        KhadisData(
            id = id,
            title = title,
            createdAt = createdAt,
            khadisId =  khadisId,
            khadisDescription = khadisDescription,
            khadisSubject = khadisSubject,
            namazImage = NamazPosterData(name = namazImage.name, type = namazImage.type, url = namazImage.url)
        )
    }
}