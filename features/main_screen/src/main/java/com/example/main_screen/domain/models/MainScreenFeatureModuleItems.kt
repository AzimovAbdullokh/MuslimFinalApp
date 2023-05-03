package com.example.main_screen.domain.models

import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel

data class MainScreenFeatureModuleItems(
//    val audioNasheeds: List<NasheedsFeatureModel>,
    val khadisses: List<KhadisFeatureModel>,
    val surah:List<SurahFeatureModuleDomainModel>
)