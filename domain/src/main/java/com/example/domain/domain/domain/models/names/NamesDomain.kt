package com.example.domain.domain.domain.models.names

data class NamesDomain(
    val id: String,
    val name: String,
    val image: NamePosterDomain,
)



data class NamePosterDomain(
    var name: String,
    var url: String,
)