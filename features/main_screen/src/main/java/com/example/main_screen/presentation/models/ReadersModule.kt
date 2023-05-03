package com.example.main_screen.presentation.models

class ReadersFeatureUiModel(
    val id: String,
    val readerId: String,
    val readerName: String,
    val readerPoster: ReaderPosterFeatureModelUi,
)

class ReaderPosterFeatureModelUi(
    var name: String,
    var url: String,
)