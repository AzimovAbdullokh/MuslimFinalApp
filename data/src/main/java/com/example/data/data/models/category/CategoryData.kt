package com.example.data.data.models.category

data class CategoryData(
    val id: String,
    val titles: String,
    val descriptions: String,
    val poster: CategoryPosterData,
)

data class CategoryPosterData(
    var name: String,
    var url: String,
)