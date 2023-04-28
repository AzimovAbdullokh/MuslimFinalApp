package com.example.data.cloud.mappers

import com.example.data.cloud.models.category.CategoryCloud
import com.example.data.data.models.category.CategoryData
import com.example.data.data.models.category.CategoryPosterData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromCategoryCloudToData @Inject constructor() : Mapper<CategoryCloud, CategoryData> {
    override fun map(from: CategoryCloud) = from.run {
        CategoryData(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryPosterData(name = poster.name, url = poster.url),
        )
    }
}