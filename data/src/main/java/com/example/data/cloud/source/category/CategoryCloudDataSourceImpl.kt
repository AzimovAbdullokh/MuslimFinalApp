package com.example.data.cloud.source.category

import com.example.data.cloud.models.category.CategoryCloud
import com.example.data.cloud.models.category.CategoryResponse
import com.example.data.cloud.service.CategoryService
import com.example.data.data.models.category.CategoryData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryCloudDataSourceImpl @Inject constructor(
    private val service: CategoryService,
    private val dispatchersProvider: DispatchersProvider,
    private val categoryCloudToData: Mapper<CategoryCloud, CategoryData>,
) : CategoryCloudDataSource {

    override fun fetchAllCategoriesFromCloud(): Flow<List<CategoryData>> =
        flow { emit(service.fetchAllCategories()) }
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: CategoryResponse(emptyList()) }
            .map { it.categories }
            .map { categories -> categories.map(categoryCloudToData::map) }
            .flowOn(dispatchersProvider.default())
}