package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import com.example.main_screen.presentation.models.SurahFeatureUiModel
import javax.inject.Inject

class SurahFeatureDomainModelToUiMapper @Inject constructor() :
    Mapper<SurahFeatureModuleDomainModel, SurahFeatureUiModel> {
    override fun map(from: SurahFeatureModuleDomainModel) = from.run {
        SurahFeatureUiModel(id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah)
    }
}