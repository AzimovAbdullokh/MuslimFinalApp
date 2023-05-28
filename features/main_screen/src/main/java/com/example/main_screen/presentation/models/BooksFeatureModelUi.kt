package com.example.main_screen.presentation.models

import java.util.*

data class BooksMainScreenFeatureModelUi(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookFeaturePdfMainScreen,
    var poster: BookFeaturePosterMainScreen,
    val publicYear: String,
    val pages: String,
    val bookFormat: String,
) {
    companion object {
        val unknown = BooksMainScreenFeatureModelUi(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookFeaturePdfMainScreen(String(), String(), String()),
            poster = BookFeaturePosterMainScreen(String(), String(), String()),
            createdAt = Date(),
            pages = String(),
            publicYear = String(),
            bookFormat = String(),
        )
    }
}

class BookFeaturePdfMainScreen(
    var name: String,
    var type: String,
    var url: String,
)

class BookFeaturePosterMainScreen(
    var name: String,
    var type: String,
    var url: String,
)