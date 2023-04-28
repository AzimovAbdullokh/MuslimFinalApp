package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.books.BookFeatureModel
import com.example.main_screen.presentation.models.BookFeaturePdf
import com.example.main_screen.presentation.models.BookFeaturePoster
import com.example.main_screen.presentation.models.BooksFeatureModelUi
import javax.inject.Inject

class BookFeatureModelToFeatureModelUiMapper @Inject constructor():
    Mapper<BookFeatureModel, BooksFeatureModelUi> {
    override fun map(from: BookFeatureModel) = from.run {
        BooksFeatureModelUi(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            bookDescription = bookDescription,
            book = BookFeaturePdf(name = book.name, type = book.type, url = book.url),
            poster = BookFeaturePoster(name = poster.name, type = poster.type, url = poster.url),
            createdAt = createdAt
        )
    }
}