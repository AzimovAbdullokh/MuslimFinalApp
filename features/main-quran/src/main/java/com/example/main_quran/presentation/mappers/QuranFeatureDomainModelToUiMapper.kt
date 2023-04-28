package com.example.main_quran.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_quran.domain.models.QuranFeatureModuleDomainModel
import com.example.main_quran.presentation.models.QuranFeatureUiModel
import javax.inject.Inject

class QuranFeatureDomainModelToUiMapper @Inject constructor() :
    Mapper<QuranFeatureModuleDomainModel, QuranFeatureUiModel> {
    override fun map(from: QuranFeatureModuleDomainModel) = from.run {
        QuranFeatureUiModel(id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah)
    }
}