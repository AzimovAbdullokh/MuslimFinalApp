package com.example.names_screen.domain.models

data class NamesFeatureDomain(
    val id: String,
    val name: String,
    val image: NameFeaturePosterDomain,
)



data class NameFeaturePosterDomain(
    var name: String,
    var url: String,
)