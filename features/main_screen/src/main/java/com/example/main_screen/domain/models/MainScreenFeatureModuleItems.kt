package com.example.main_screen.domain.models

import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.models.quiz.CategoryMainScreenFeatureDomain
import com.example.main_screen.domain.models.readers.ReadersFeatureMainModel
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel

data class MainScreenFeatureModuleItems(
    val khadisses: List<KhadisFeatureModel>,
    val surah: List<SurahFeatureModuleDomainModel>,
    val readers: List<ReadersFeatureMainModel>,
    val books:List<BookMainScreenFeatureModel>,
    val categories:List<CategoryMainScreenFeatureDomain>
)