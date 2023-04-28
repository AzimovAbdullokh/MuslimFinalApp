package com.example.data.cloud.mappers

import com.example.data.cloud.models.surah.SurahCloud
import com.example.data.cloud.models.surah.SurahResponseCloud
import com.example.data.data.models.surah.SurahData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class SurahResponseCloudToDataMapper @Inject constructor() :
    Mapper<SurahResponseCloud, SurahCloud> {

    override fun map(from: SurahResponseCloud): SurahCloud {
        if (from.surah.isEmpty()) return SurahCloud.unknown
        val surah = from.surah.first()
        return SurahCloud(
            id = surah.id,
            surahId = surah.surahId,
            surahName = surah.surahName,
            surahArabName = surah.surahArabName,
            surahCountInQuran = surah.surahCountInQuran,
            surah = surah.surah,
        )
    }
}