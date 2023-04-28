package com.example.data.data.mappers

import com.example.data.data.models.books.BookData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookPdfDomain
import com.example.domain.domain.domain.models.books.BookPosterDomain
import com.example.domain.domain.domain.models.books.BookDomain
import javax.inject.Inject

class MapFromBookDataToDomain @Inject constructor():Mapper<BookData, BookDomain> {
    override fun map(from: BookData) = from.run {
       BookDomain(
           bookTitle = bookTitle,
           bookAuthor = bookAuthor,
           id = id,
           bookDescription = bookDescription,
           book = BookPdfDomain(name = book.name, type = book.type, url = book.url),
           poster = BookPosterDomain(name = poster.name, type = poster.type, url = poster.url),
           createdAt = createdAt
       )
    }
}