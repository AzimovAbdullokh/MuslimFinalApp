package com.example.main_screen.domain.models

import com.example.main_screen.domain.models.books.BookFeatureModel
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.models.nasheeds.NasheedsFeatureModel
import com.example.main_screen.domain.models.readers.ReadersFeatureModel
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel

data class MainScreenFeatureModuleItems(
    val books: List<BookFeatureModel>,
    val audioNasheeds: List<NasheedsFeatureModel>,
    val khadisses: List<KhadisFeatureModel>,
    val readers: List<ReadersFeatureModel>,
    val surah:List<SurahFeatureModuleDomainModel>
)