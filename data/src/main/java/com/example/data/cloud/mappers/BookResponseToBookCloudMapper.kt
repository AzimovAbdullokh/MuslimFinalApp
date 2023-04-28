package com.example.data.cloud.mappers

import com.example.data.cloud.models.books.BookCloud
import com.example.data.cloud.models.books.BookPdfCloud
import com.example.data.cloud.models.books.BookPosterCloud
import com.example.data.cloud.models.books.BookResponseCloud
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class BookResponseToBookCloudMapper @Inject constructor() : Mapper<BookResponseCloud, BookCloud> {

    override fun map(from: BookResponseCloud): BookCloud {
        if (from.books.isEmpty()) return BookCloud.unknown
        val book = from.books.first()
        return BookCloud(id = book.id,
            bookAuthor = book.bookAuthor,
            createdAt = book.createdAt,
            bookTitle = book.bookTitle,
            book = BookPdfCloud(name = book.book.name, url = book.book.url, type = book.book.type),
            poster = BookPosterCloud(name = book.poster.name,
                url = book.poster.url,
                type = book.poster.type),
            bookDescription = book.bookDescription)
    }
}