package com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.main_screen.domain.models.books.BookFeatureModel
import com.example.main_screen.domain.models.books.BookPdfModuleDomain
import com.example.main_screen.domain.models.books.BookPosterModuleDomain
import javax.inject.Inject

class BookDomainToBookFeatureModelMapper @Inject constructor():Mapper<BookDomain, BookFeatureModel> {
    override fun map(from: BookDomain) = from.run {
        BookFeatureModel(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            bookDescription = bookDescription,
            book = BookPdfModuleDomain(name = book.name, type = book.type, url = book.url),
            poster = BookPosterModuleDomain(name = poster.name, type = poster.type, url = poster.url),
            createdAt = createdAt
        )
    }
}