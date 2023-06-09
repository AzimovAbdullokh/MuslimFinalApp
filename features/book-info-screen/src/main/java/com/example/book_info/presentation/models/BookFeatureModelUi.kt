package com.example.book_info.presentation.models

import java.util.*

class BookFeatureModelUi(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookPdfFeatureModelUi,
    var poster: BookPosterFeatureModelUi,
    val publicYear: String,
    val pages: String,
    val bookFormat: String,
    ) {
    companion object {
        val unknown = BookFeatureModelUi(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookPdfFeatureModelUi(String(), String(), String()),
            poster = BookPosterFeatureModelUi(String(), String(), String()),
            createdAt = Date(),
            pages = String(),
            publicYear = String(),
            bookFormat = String(),
        )
    }
}

class BookPdfFeatureModelUi(
    var name: String,
    var type: String,
    var url: String,
)

class BookPosterFeatureModelUi(
    var name: String,
    var type: String,
    var url: String,
)