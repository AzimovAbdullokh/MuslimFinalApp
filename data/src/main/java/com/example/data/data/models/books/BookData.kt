package com.example.data.data.models.books

import java.util.Date

class BookData(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookPdfData,
    var poster: BookPosterData,

    ) {
    companion object {
        val unknown = BookData(id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookPdfData(String(), String(), String()),
            poster = BookPosterData(String(), String(), String()),
            createdAt = Date())
    }
}

class BookPdfData(
    var name: String,
    var type: String,
    var url: String,
)

class BookPosterData(
    var name: String,
    var type: String,
    var url: String,
)