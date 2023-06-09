package com.example.alarms.domain.models.readers

class ReadersFeatureModel(
    val id: String,
    val readerId: String,
    val readerName: String,
    val readerPoster: ReaderFeaturePoster,
)

class ReaderFeaturePoster(
    var name: String,
    var url: String,
)