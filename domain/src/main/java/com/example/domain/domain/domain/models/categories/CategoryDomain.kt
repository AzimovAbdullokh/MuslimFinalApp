package com.example.domain.domain.domain.models.categories

data class CategoryDomain(
    val id: String,
    val titles: String,
    val descriptions: String,
    val poster: CategoryPosterDomain,
)

data class CategoryPosterDomain(
    var name: String,
    var url: String,
)