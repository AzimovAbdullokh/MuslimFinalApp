package com.example.main_screen.domain.models.readers

class ReadersFeatureMainModel(
    val id: String,
    val readerId: String,
    val readerName: String,
    val readerPoster: ReaderFeatureMainPoster,
)

class ReaderFeatureMainPoster(
    var name: String,
    var url: String,
)