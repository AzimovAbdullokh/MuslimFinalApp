package com.example.main_screen.domain.models.quiz

data class CategoryMainScreenFeatureDomain(
    val id: String,
    val titles: String,
    val descriptions: String,
    val poster: CategoryMainScreenFeaturePosterDomain,
)

data class CategoryMainScreenFeaturePosterDomain(
    var name: String,
    var url: String,
)