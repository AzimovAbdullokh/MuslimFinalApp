package com.example.data.data.models.readers

class ReadersData(
    val id: String,
    val readerId: String,
    val readerName: String,
    val readerPoster: ReaderPosterData,
)

class ReaderPosterData(
    var name: String,
    var url: String,
)