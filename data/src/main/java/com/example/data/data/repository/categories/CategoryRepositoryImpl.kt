package com.example.data.data.repository.categories

import com.example.data.cache.source.categories.CategoriesCacheDataSource
import com.example.data.cloud.source.category.CategoryCloudDataSource
import com.example.data.data.models.category.CategoryData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import com.example.domain.domain.domain.repositories.CategoryRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val cloudDataSource: CategoryCloudDataSource,
    private val cacheDataSource: CategoriesCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val categoryDataToDomainMapper: Mapper<CategoryData, CategoryDomain>,
) : CategoryRepository {

    override fun fetchAllCategories(): Flow<List<CategoryDomain>> =
        flow { emit(cacheDataSource.fetchAllCategoriesFromCacheSingle()) }
            .flatMapLatest { handleFetchCategoriesInCache(it) }
            .map { categories -> categories.map(categoryDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    private fun handleFetchCategoriesInCache(
        cachedCategories: List<CategoryData>,
    ) = if (cachedCategories.isEmpty()) cloudDataSource.fetchAllCategoriesFromCloud()
        .onEach { categories -> categories.forEach { cacheDataSource.addNewCategoryToCache(it) } }
    else cacheDataSource.fetchAllCategoriesFromCacheObservable()

    override suspend fun fetchCategoriesFromCache(categoryId: String): CategoryDomain {
        return categoryDataToDomainMapper.map(cacheDataSource.fetchCategoryFromId(categoryId = categoryId))
    }
}