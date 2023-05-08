package test_screen.test_category_screen.presentation.models

import com.example.common_api.base.adapter.Item
import test_screen.test_category_screen.presentation.listener.CategoryItemClickListener

data class CategoryFeatureAdapterModel(
    val testCategories: CategoryFeatureUi,
    val listener: CategoryItemClickListener,
) : Item {
    fun id() = testCategories.id + testCategories.titles
}