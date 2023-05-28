package com.example.book_info.domain.models

import java.util.*

class BookFeatureModelDomain(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookPdfFeatureModelDomain,
    var poster: BookPosterFeatureModelDomain,
    val publicYear: String,
    val pages: String,
    val bookFormat: String,
    ) {
    companion object {
        val unknown = BookFeatureModelDomain(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookPdfFeatureModelDomain(String(), String(), String()),
            poster = BookPosterFeatureModelDomain(String(), String(), String()),
            createdAt = Date(),
            pages = String(),
            publicYear = String(),
            bookFormat = String(),
        )
    }
}

class BookPdfFeatureModelDomain(
    var name: String,
    var type: String,
    var url: String,
)

class BookPosterFeatureModelDomain(
    var name: String,
    var type: String,
    var url: String,
)