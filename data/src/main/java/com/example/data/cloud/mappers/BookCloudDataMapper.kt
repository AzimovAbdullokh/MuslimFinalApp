package com.example.data.cloud.mappers

import com.example.data.cloud.models.books.BookCloud
import com.example.data.data.models.books.BookData
import com.example.data.data.models.books.BookPdfData
import com.example.data.data.models.books.BookPosterData
import com.example.domain.domain.domain.Mapper

interface BookCloudDataMapper {

    fun map(from: BookCloud): BookData

    fun map(): Mapper<BookCloud, BookData>
}

class BookCloudDataMapperImpl : BookCloudDataMapper {

    override fun map(from: BookCloud) = createBookData(from)

    override fun map() = object : Mapper<BookCloud, BookData> {
        override fun map(from: BookCloud): BookData = createBookData(from)

    }

    private fun createBookData(bookCloud: BookCloud) = bookCloud.run {
        BookData(bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            bookDescription = bookDescription,
            book = BookPdfData(name = book.name, type = book.type, url = book.url),
            poster = BookPosterData(name = poster.name, type = poster.type, url = poster.url),
            createdAt = createdAt)
    }
}