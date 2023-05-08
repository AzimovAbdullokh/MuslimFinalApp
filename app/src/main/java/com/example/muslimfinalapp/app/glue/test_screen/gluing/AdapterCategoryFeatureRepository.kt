package com.example.muslimfinalapp.app.glue.test_screen.gluing

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.domain.domain.domain.repositories.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain
import test_screen.test_category_screen.domain.repository.CategoryFeatureRepository
import javax.inject.Inject

class AdapterCategoryFeatureRepository @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val categoryDomainToFeatureModelMapper: Mapper<CategoryDomain, CategoryFeatureDomain>,
) : CategoryFeatureRepository {

    override fun fetchAllCategories(): Flow<List<CategoryFeatureDomain>> =
        categoryRepository.fetchAllCategories()
            .map { category -> category.map(categoryDomainToFeatureModelMapper::map) }
}