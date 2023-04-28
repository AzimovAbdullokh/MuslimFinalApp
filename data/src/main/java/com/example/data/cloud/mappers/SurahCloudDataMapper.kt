package com.example.data.cloud.mappers

import com.example.data.cloud.models.surah.SurahCloud
import com.example.data.data.models.surah.SurahData
import com.example.domain.domain.domain.Mapper

interface SurahCloudDataMapper {

    fun map(from: SurahCloud): SurahData

    fun map(): Mapper<SurahCloud, SurahData>
}

class SurahCloudDataMapperImpl : SurahCloudDataMapper {

    override fun map(from: SurahCloud) = createSurahData(from)

    override fun map() = object : Mapper<SurahCloud, SurahData> {
        override fun map(from: SurahCloud): SurahData = createSurahData(from)

    }

    private fun createSurahData(surahCloud: SurahCloud) = surahCloud.run {
        SurahData(
            id = id,
            surahId = surahId,
            surahName = surahName,
            surahArabName = surahArabName,
            surahCountInQuran = surahCountInQuran,
            surah = surah,
        )
    }

}