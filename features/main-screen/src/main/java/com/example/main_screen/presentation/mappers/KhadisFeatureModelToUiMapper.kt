package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.presentation.models.KhadissesFeatureUi
import javax.inject.Inject

class KhadisFeatureModelToUiMapper @Inject constructor():Mapper<KhadisFeatureModel, KhadissesFeatureUi> {
    override fun map(from: KhadisFeatureModel) = from.run {
        KhadissesFeatureUi(
            id = id,
            title = title,
            createdAt = createdAt,
            khadisId = khadisId,
            khadisDescription = khadisDescription,
            khadisSubject = khadisSubject
        )
    }
}