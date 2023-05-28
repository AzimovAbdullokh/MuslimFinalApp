package com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.main_screen.domain.models.quiz.CategoryMainScreenFeatureDomain
import com.example.main_screen.domain.models.quiz.CategoryMainScreenFeaturePosterDomain
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain
import test_screen.test_category_screen.domain.models.CategoryFeaturePosterDomain
import javax.inject.Inject

class QuizCategoryDomainToFeatureModelMapper @Inject constructor(): Mapper<CategoryDomain, CategoryMainScreenFeatureDomain> {
    override fun map(from: CategoryDomain) = from.run {
        CategoryMainScreenFeatureDomain(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryMainScreenFeaturePosterDomain(name = poster.name, url = poster.url)
        )
    }
}