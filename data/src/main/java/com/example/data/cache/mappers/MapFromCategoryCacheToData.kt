package com.example.data.cache.mappers

import com.example.data.cache.models.CategoryCache
import com.example.data.cache.models.CategoryPosterCache
import com.example.data.data.models.category.CategoryData
import com.example.data.data.models.category.CategoryPosterData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromCategoryCacheToData @Inject constructor() : Mapper<CategoryCache, CategoryData> {
    override fun map(from: CategoryCache) = from.run {
        CategoryData(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryPosterData(name = poster.name, url = poster.url),
        )
    }
}


class MapFromCategoryDataToCache @Inject constructor(): Mapper<CategoryData, CategoryCache> {
    override fun map(from: CategoryData) = from.run {
        CategoryCache(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryPosterCache(name = poster.name, url = poster.url),
        )
    }
}