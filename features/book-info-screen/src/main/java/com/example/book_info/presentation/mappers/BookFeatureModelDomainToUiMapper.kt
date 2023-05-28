package com.example.book_info.presentation.mappers

import com.example.book_info.domain.models.BookFeatureModelDomain
import com.example.book_info.presentation.models.BookFeatureModelUi
import com.example.book_info.presentation.models.BookPdfFeatureModelUi
import com.example.book_info.presentation.models.BookPosterFeatureModelUi
import com.example.common_api.Mapper
import javax.inject.Inject

class BookFeatureModelDomainToUiMapper @Inject constructor() :
    Mapper<BookFeatureModelDomain, BookFeatureModelUi> {
    override fun map(from: BookFeatureModelDomain) = from.run {
        BookFeatureModelUi(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            bookDescription = bookDescription,
            book = BookPdfFeatureModelUi(name = book.name, type = book.type, url = book.url),
            poster = BookPosterFeatureModelUi(name = poster.name,
                type = poster.type,
                url = poster.url),
            createdAt = createdAt,
            pages = pages,
            publicYear = publicYear,
            bookFormat = bookFormat,
        )
    }
}