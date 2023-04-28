package com.example.data.cache.source.categories

import com.example.data.cache.db.CategoryDao
import com.example.data.cache.models.CategoryCache
import com.example.data.data.models.category.CategoryData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoriesCacheDataSourceImpl @Inject constructor(
    private val dao: CategoryDao,
    private val dispatchersProvider: DispatchersProvider,
    private val categoryCacheToDataMapper: Mapper<CategoryCache, CategoryData>,
    private val categoryDataToCacheMapper: Mapper<CategoryData, CategoryCache>,
) : CategoriesCacheDataSource {

    override fun fetchAllCategoriesFromCacheObservable(): Flow<List<CategoryData>> =
        dao.fetchAllCategoriesObservable()
            .flowOn(dispatchersProvider.io())
            .map { categories -> categories.map(categoryCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchAllCategoriesFromCacheSingle(): List<CategoryData> {
        val cachedList = dao.fetchAllCategoriesSingle()
        return cachedList.map(categoryCacheToDataMapper::map)
    }

    override suspend fun addNewCategoryToCache(category: CategoryData) {
        dao.addNewCategory(categoryDataToCacheMapper.map(category))
    }

    override suspend fun fetchCategoryFromId(categoryId: String): CategoryData =
        categoryCacheToDataMapper.map(dao.fetchCategoryFromId(categoryId = categoryId))

    override suspend fun clearTable() {
        dao.clearTable()
    }
}