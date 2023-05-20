package com.example.data.cloud.source.category

import com.example.data.cloud.models.category.CategoryCloud
import com.example.data.cloud.models.category.CategoryResponse
import com.example.data.cloud.models.tests.TestQuestionCloud
import com.example.data.cloud.models.tests.TestResponse
import com.example.data.cloud.service.TestCategoryService
import com.example.data.data.models.category.CategoryData
import com.example.data.data.models.tests.TestQuestionData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryCloudDataSourceImpl @Inject constructor(
    private val service: TestCategoryService,
    private val dispatchersProvider: DispatchersProvider,
    private val categoryCloudToDataMapper: Mapper<CategoryCloud, CategoryData>,
    private val questionCloudToDataMapper: Mapper<TestQuestionCloud, TestQuestionData>,
) : CategoryCloudDataSource {

    override fun fetchAllCategoriesFromCloud(): Flow<List<CategoryData>> =
        flow { emit(service.fetchAllCategories()) }
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: CategoryResponse(emptyList()) }
            .map { it.categories }
            .map { categories -> categories.map(categoryCloudToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override fun fetchAllQuestionsFromCloud(): Flow<List<TestQuestionData>> =
        flow { emit(service.fetchAllTests()) }
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: TestResponse(emptyList()) }
            .map { it.questions }
            .map { questions -> questions.map(questionCloudToDataMapper::map) }
            .flowOn(dispatchersProvider.default())
}