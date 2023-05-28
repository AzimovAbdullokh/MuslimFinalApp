package com.example.main_screen.domain.repository

import com.example.main_screen.domain.models.quiz.CategoryMainScreenFeatureDomain
import kotlinx.coroutines.flow.Flow

interface CategoryMainScreenFeatureRepository {

    fun fetchAllCategories(): Flow<List<CategoryMainScreenFeatureDomain>>
}