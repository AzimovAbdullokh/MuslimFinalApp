package test_screen.test_category_screen.domain.repository

import kotlinx.coroutines.flow.Flow
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain

interface CategoryFeatureRepository {

    fun fetchAllCategories(): Flow<List<CategoryFeatureDomain>>
}