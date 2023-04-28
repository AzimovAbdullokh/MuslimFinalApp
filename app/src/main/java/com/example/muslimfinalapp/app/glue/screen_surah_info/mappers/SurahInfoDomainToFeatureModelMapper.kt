package com.example.muslimfinalapp.app.glue.screen_surah_info.mappers

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import com.example.surah_info.domain.models.SurahInfoFeatureModuleDomainModel
import javax.inject.Inject

class SurahInfoDomainToFeatureModelMapper @Inject constructor() :
    Mapper<SurahDomain, SurahInfoFeatureModuleDomainModel> {
    override fun map(from: SurahDomain) = from.run {
        SurahInfoFeatureModuleDomainModel(
            id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah)
    }
}