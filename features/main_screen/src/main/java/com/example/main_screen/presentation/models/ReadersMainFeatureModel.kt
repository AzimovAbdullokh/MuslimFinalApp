package com.example.main_screen.presentation.models

class ReadersFeatureMainUiModel(
    val id: String,
    val readerId: String,
    val readerName: String,
    val readerPoster: ReaderPosterFeatureMainModelUi,
)

class ReaderPosterFeatureMainModelUi(
    var name: String,
    var url: String,
)