package com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import javax.inject.Inject

class SurahDomainToFeatureModelMapper @Inject constructor() :
    Mapper<SurahDomain, SurahFeatureModuleDomainModel> {
    override fun map(from: SurahDomain) = from.run {
        SurahFeatureModuleDomainModel(id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah)
    }
}