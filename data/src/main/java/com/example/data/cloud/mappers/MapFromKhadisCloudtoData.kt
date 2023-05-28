package com.example.data.cloud.mappers

import com.example.data.cloud.models.khadisses.KhadisCloud
import com.example.data.data.models.khadisses.KhadisData
import com.example.data.data.models.khadisses.NamazPosterData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromKhadisCloudtoData @Inject constructor() : Mapper<KhadisCloud, KhadisData> {
    override fun map(from: KhadisCloud) = from.run {
        KhadisData(id = id,
            title = title,
            createdAt = createdAt,
            khadisId = khadisId,
            khadisDescription = khadisDescription,
            khadisSubject = khadisSubject,
            namazImage = NamazPosterData(type = namazImage.type, url = namazImage.url, name = namazImage.name)
        )
    }
}