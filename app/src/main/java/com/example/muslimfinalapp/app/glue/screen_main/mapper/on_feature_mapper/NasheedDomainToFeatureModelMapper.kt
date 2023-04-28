package com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.main_screen.domain.models.nasheeds.NasheedFeatureFile
import com.example.main_screen.domain.models.nasheeds.NasheedFeaturePoster
import com.example.main_screen.domain.models.nasheeds.NasheedsFeatureModel
import javax.inject.Inject

class NasheedDomainToFeatureModelMapper @Inject constructor() :
    Mapper<NasheedsDomain, NasheedsFeatureModel> {
    override fun map(from: NasheedsDomain) = from.run {
        NasheedsFeatureModel(id = id,
            title = title,
            createdAt = createdAt,
            nasheedFile = NasheedFeatureFile(name = nasheedFile.name, url = nasheedFile.url),
            nasheedPoster = NasheedFeaturePoster(name = nasheedPoster.name,
                url = nasheedPoster.url),
            audioId = audioId,
            currentStartPosition = currentStartPosition)
    }
}