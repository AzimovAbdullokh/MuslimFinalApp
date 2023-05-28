package com.example.data.data.mappers

import com.example.data.data.models.khadisses.KhadisData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.domain.domain.domain.models.khadisses.NamazPosterDomain
import javax.inject.Inject

class MapFromKhadisDataToDomain @Inject constructor() : Mapper<KhadisData, KhadisDomain> {
    override fun map(from: KhadisData) = from.run {
        KhadisDomain(
            id = id,
            title = title,
            createdAt = createdAt,
            khadisId = khadisId,
            khadisDescription = khadisDescription,
            khadisSubject = khadisSubject,
            namazImage = NamazPosterDomain(
                name = namazImage.name,
                type = namazImage.type,
                url = namazImage.url,
            )
        )
    }
}