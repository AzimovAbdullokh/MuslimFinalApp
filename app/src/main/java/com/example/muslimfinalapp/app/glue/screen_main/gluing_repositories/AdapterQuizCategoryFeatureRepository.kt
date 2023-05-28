package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.domain.domain.domain.repositories.CategoryRepository
import com.example.main_screen.domain.models.quiz.CategoryMainScreenFeatureDomain
import com.example.main_screen.domain.repository.CategoryMainScreenFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain
import test_screen.test_category_screen.domain.repository.CategoryFeatureRepository
import javax.inject.Inject

class AdapterQuizCategoryFeatureRepository @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val categoryDomainToFeatureModelMapper: Mapper<CategoryDomain, CategoryMainScreenFeatureDomain>,
) : CategoryMainScreenFeatureRepository {

    override fun fetchAllCategories(): Flow<List<CategoryMainScreenFeatureDomain>> =
        categoryRepository.fetchAllCategories()
            .map { category -> category.map(categoryDomainToFeatureModelMapper::map) }
}