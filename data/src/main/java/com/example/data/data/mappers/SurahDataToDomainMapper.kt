package com.example.data.data.mappers

import com.example.data.data.models.surah.SurahData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.surah.SurahDomain
import javax.inject.Inject

class SurahDataToDomainMapper @Inject constructor() : Mapper<SurahData, SurahDomain> {
    override fun map(from: SurahData) = from.run {
        SurahDomain(
            id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah
        )
    }
}