package com.example.data.cache.mappers

import com.example.data.cache.models.BookCache
import com.example.data.cache.models.BookPdfCache
import com.example.data.cache.models.BookPosterCache
import com.example.data.data.models.books.BookData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class MapFromBookDataToCache @Inject constructor():Mapper<BookData, BookCache> {
    override fun map(from: BookData) = from.run {
        BookCache(
            id = id,
            createdAt = createdAt,
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            bookDescription = bookDescription,
            book = BookPdfCache(name = book.name, type = book.type, url = book.url),
            bookPoster = BookPosterCache(name = poster.name, url = poster.url, type = poster.type)
        )
    }
}