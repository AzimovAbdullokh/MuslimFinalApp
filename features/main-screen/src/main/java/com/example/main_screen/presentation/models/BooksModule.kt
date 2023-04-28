package com.example.main_screen.presentation.models

import java.util.*

data class BooksFeatureModelUi(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookFeaturePdf,
    var poster: BookFeaturePoster,
) {
    companion object {
        val unknown = BooksFeatureModelUi(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookFeaturePdf(String(), String(), String()),
            poster = BookFeaturePoster(String(), String(), String()),
            createdAt = Date(),
        )
    }
}

class BookFeaturePdf(
    var name: String,
    var type: String,
    var url: String,
)

class BookFeaturePoster(
    var name: String,
    var type: String,
    var url: String,
)