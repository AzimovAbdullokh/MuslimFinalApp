package com.example.muslimfinalapp.app.ui.screen_test_category.model

import com.example.common_api.base.adapter.Item
import com.example.muslimfinalapp.app.ui.screen_test_category.listener.CategoryItemOnClickListener

data class CategoryAdapterModel(
    val id: String,
    val titles: String,
    val posterUrl: String,
    val listener: CategoryItemOnClickListener
) : Item