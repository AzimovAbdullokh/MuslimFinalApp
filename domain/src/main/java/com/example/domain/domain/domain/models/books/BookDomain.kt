package com.example.domain.domain.domain.models.books

import java.util.*

class BookDomain(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookPdfDomain,
    var poster: BookPosterDomain,

    ) {
    companion object {
        val unknown = BookDomain(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookPdfDomain(String(), String(), String()),
            poster = BookPosterDomain(String(), String(), String()),
            createdAt = Date()
        )
    }
}

class BookPdfDomain(
    var name: String,
    var type: String,
    var url: String,
)

class BookPosterDomain(
    var name: String,
    var type: String,
    var url: String,
)