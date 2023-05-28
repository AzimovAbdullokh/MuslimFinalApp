package com.example.main_screen.domain.models.books

import java.util.*

class BookMainScreenFeatureModel(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookPdfMainScreen,
    var poster: BookPosterMainScreen,
    val publicYear: String,
    val pages: String,
    val bookFormat: String,
    ) {
    companion object {
        val unknown = BookMainScreenFeatureModel(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookPdfMainScreen(String(), String(), String()),
            poster = BookPosterMainScreen(String(), String(), String()),
            createdAt = Date(),
            pages = String(),
            publicYear = String(),
            bookFormat = String(),
        )
    }
}

class BookPdfMainScreen(
    var name: String,
    var type: String,
    var url: String,
)

class BookPosterMainScreen(
    var name: String,
    var type: String,
    var url: String,
)