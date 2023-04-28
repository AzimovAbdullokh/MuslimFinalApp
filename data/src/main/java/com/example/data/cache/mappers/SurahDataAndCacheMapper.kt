package com.example.data.cache.mappers

import com.example.data.cache.models.SurahCache
import com.example.data.data.models.surah.SurahData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class SurahDataToCacheMapper @Inject constructor(): Mapper<SurahData, SurahCache> {
    override fun map(from: SurahData) = from.run {
        SurahCache(id = id,
            surah = surah,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surahId = surahId
        )
    }
}

class SurahCacheToDataMapper @Inject constructor(): Mapper<SurahCache, SurahData> {
    override fun map(from: SurahCache) = from.run {
        SurahData(
            id = id,
            surah = surah,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surahId = surahId
        )
    }
}