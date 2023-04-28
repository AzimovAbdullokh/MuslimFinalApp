package com.example.main_screen.domain.models.books

import java.util.*

class BookFeatureModel(
    val bookTitle: String,
    val bookAuthor: String,
    var id: String,
    var createdAt: Date,
    val bookDescription: String,
    var book: BookPdfModuleDomain,
    var poster: BookPosterModuleDomain,

    ) {
    companion object {
        val unknown = BookFeatureModel(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookPdfModuleDomain(String(), String(), String()),
            poster = BookPosterModuleDomain(String(), String(), String()),
            createdAt = Date()
        )
    }
}

class BookPdfModuleDomain(
    var name: String,
    var type: String,
    var url: String,
)

class BookPosterModuleDomain(
    var name: String,
    var type: String,
    var url: String,
)