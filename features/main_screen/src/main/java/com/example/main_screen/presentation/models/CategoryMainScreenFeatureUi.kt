package com.example.main_screen.presentation.models

data class CategoryMainScreenFeatureUi(
    val id: String,
    val titles: String,
    val descriptions: String,
    val poster: CategoryMainScreenFeaturePosterui,
    val type:CategoryTypes
)

data class CategoryMainScreenFeaturePosterui(
    var name: String,
    var url: String,
)