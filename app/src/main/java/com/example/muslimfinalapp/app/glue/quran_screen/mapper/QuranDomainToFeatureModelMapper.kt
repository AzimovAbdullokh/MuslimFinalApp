package com.example.muslimfinalapp.app.glue.quran_screen.mapper

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.main_quran.domain.models.QuranFeatureModuleDomainModel
import javax.inject.Inject

class QuranDomainToFeatureModelMapper @Inject constructor() :
    Mapper<SurahDomain, QuranFeatureModuleDomainModel> {
    override fun map(from: SurahDomain) = from.run {
        QuranFeatureModuleDomainModel(id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah)
    }
}