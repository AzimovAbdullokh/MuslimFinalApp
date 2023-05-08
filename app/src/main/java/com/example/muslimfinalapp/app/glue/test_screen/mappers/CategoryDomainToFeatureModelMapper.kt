package com.example.muslimfinalapp.app.glue.test_screen.mappers

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.categories.CategoryDomain
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain
import test_screen.test_category_screen.domain.models.CategoryFeaturePosterDomain
import javax.inject.Inject

class CategoryDomainToFeatureModelMapper @Inject constructor(): Mapper<CategoryDomain, CategoryFeatureDomain> {
    override fun map(from: CategoryDomain) = from.run {
        CategoryFeatureDomain(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryFeaturePosterDomain(name = poster.name, url = poster.url)
        )
    }
}