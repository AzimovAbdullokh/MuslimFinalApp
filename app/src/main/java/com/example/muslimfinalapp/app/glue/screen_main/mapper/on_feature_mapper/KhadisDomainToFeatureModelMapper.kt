package com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.models.khadisses.NamazPosterFeatureModel
import javax.inject.Inject

class KhadisDomainToFeatureModelMapper @Inject constructor() :
    Mapper<KhadisDomain, KhadisFeatureModel> {
    override fun map(from: KhadisDomain) = from.run {
        KhadisFeatureModel(id = id,
            title = title,
            createdAt = createdAt,
            khadisId = khadisId,
            khadisDescription = khadisDescription,
            khadisSubject = khadisSubject,
            namazImage = NamazPosterFeatureModel(
                name = namazImage.name,
                type = namazImage.type,
                url = namazImage.url,
            ))
    }
}