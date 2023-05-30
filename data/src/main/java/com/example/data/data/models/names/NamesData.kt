package com.example.data.data.models.names

data class NamesData(
    val id:String,
    val name: String,
    val image: NamePosterData,
)

data class NamePosterData(
    var name: String,
    var url: String,
)