package com.example.data.data.mappers

import com.example.data.data.models.category.CategoryData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.domain.domain.domain.models.categories.CategoryPosterDomain
import javax.inject.Inject

class MapFromCategoryDataToDomain @Inject constructor() : Mapper<CategoryData, CategoryDomain> {
    override fun map(from: CategoryData) = from.run {
        CategoryDomain(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryPosterDomain(name = poster.name, url = poster.url)
        )
    }
}