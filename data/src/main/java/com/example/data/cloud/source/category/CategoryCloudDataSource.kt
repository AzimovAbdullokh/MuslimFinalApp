package com.example.data.cloud.source.category

import com.example.data.data.models.category.CategoryData
import com.example.data.data.models.tests.TestQuestionData
import kotlinx.coroutines.flow.Flow

interface CategoryCloudDataSource {

    fun fetchAllCategoriesFromCloud(): Flow<List<CategoryData>>

    fun fetchAllQuestionsFromCloud():Flow<List<TestQuestionData>>
}