package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun fetchAllCategories(): Flow<List<CategoryDomain>>

    suspend fun fetchCategoriesFromCache(categoryId: String): CategoryDomain

}