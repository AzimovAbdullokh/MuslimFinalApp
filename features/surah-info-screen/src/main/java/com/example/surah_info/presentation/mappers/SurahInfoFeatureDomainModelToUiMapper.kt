package com.example.surah_info.presentation.mappers

import com.example.common_api.Mapper
import com.example.surah_info.domain.models.SurahInfoFeatureModuleDomainModel
import com.example.surah_info.presentation.models.SurahInfoFeatureUiModel
import javax.inject.Inject

class SurahInfoFeatureDomainModelToUiMapper @Inject constructor() :
    Mapper<SurahInfoFeatureModuleDomainModel, SurahInfoFeatureUiModel> {
    override fun map(from: SurahInfoFeatureModuleDomainModel) = from.run {
        SurahInfoFeatureUiModel(id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah)
    }
}