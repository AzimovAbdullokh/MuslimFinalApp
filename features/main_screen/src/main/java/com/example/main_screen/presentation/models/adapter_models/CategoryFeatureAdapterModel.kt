package com.example.main_screen.presentation.models.adapter_models

import com.example.common_api.base.adapter.Item
import com.example.main_screen.presentation.listeners.QuizCategoryItemClickListener
import com.example.main_screen.presentation.models.CategoryMainScreenFeatureUi

data class CategoryFeatureAdapterModel(
    val testCategories: CategoryMainScreenFeatureUi,
    val listener: QuizCategoryItemClickListener,
) : Item {
    fun id() = testCategories.id + testCategories.titles
}