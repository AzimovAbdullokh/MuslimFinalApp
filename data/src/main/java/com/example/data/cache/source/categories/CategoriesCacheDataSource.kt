package com.example.data.cache.source.categories

import com.example.data.data.models.category.CategoryData
import kotlinx.coroutines.flow.Flow

interface CategoriesCacheDataSource {

    fun fetchAllCategoriesFromCacheObservable(): Flow<List<CategoryData>>

    suspend fun fetchAllCategoriesFromCacheSingle(): List<CategoryData>

    suspend fun addNewCategoryToCache(category: CategoryData)

    suspend fun fetchCategoryFromId(categoryId: String): CategoryData

    suspend fun clearTable()
}