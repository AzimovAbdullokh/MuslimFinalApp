package com.example.domain.domain.domain.models.readers

class ReaderDomain(
    val id: String,
    val readerId: String,
    val readerName: String,
    val readerPoster: ReaderPosterDomain,
)

class ReaderPosterDomain(
    var name: String,
    var url: String,
)