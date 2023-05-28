package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.quiz.CategoryMainScreenFeatureDomain
import com.example.main_screen.presentation.models.CategoryMainScreenFeaturePosterui
import com.example.main_screen.presentation.models.CategoryMainScreenFeatureUi
import com.example.main_screen.presentation.models.CategoryTypes
import javax.inject.Inject

class QuizCategoryFeatureDomainToUiMapper @Inject constructor() :
    Mapper<CategoryMainScreenFeatureDomain, CategoryMainScreenFeatureUi> {
    override fun map(from: CategoryMainScreenFeatureDomain) = from.run {
        CategoryMainScreenFeatureUi(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryMainScreenFeaturePosterui(name = poster.name, url = poster.url),
            type = CategoryTypes.DEFAULT
        )
    }
}