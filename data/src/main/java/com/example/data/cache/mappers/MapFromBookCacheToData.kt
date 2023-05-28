package com.example.data.cache.mappers

import com.example.data.cache.models.BookCache
import com.example.data.data.models.books.BookData
import com.example.data.data.models.books.BookPdfData
import com.example.data.data.models.books.BookPosterData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromBookCacheToData @Inject constructor() : Mapper<BookCache, BookData> {
    override fun map(from: BookCache) = from.run {
        BookData(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            createdAt = createdAt,
            bookDescription = bookDescription,
            book = BookPdfData(name = book.name, type = book.type, url = book.url),
            poster = BookPosterData(name = bookPoster.name, url= bookPoster.url, type=bookPoster.type),
            pages = pages,
            publicYear = publicYear,
            bookFormat = bookFormat
        )
    }
}