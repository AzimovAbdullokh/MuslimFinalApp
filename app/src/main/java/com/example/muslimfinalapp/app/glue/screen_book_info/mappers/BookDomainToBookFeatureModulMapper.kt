package com.example.muslimfinalapp.app.glue.screen_book_info.mappers

import com.example.book_info.domain.models.BookFeatureModelDomain
import com.example.book_info.domain.models.BookPdfFeatureModelDomain
import com.example.book_info.domain.models.BookPosterFeatureModelDomain
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.main_screen.domain.models.books.BookFeatureModel
import com.example.main_screen.domain.models.books.BookPdfModuleDomain
import com.example.main_screen.domain.models.books.BookPosterModuleDomain
import javax.inject.Inject

class BookDomainToBookFeatureModulMapper @Inject constructor() :
    Mapper<BookDomain, BookFeatureModelDomain> {
    override fun map(from: BookDomain) = from.run {
        BookFeatureModelDomain(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            bookDescription = bookDescription,
            book = BookPdfFeatureModelDomain(name = book.name, type = book.type, url = book.url),
            poster = BookPosterFeatureModelDomain(name = poster.name,
                type = poster.type,
                url = poster.url),
            createdAt = createdAt
        )
    }
}