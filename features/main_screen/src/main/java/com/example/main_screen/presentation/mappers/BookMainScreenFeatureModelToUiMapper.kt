package com.example.main_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import com.example.main_screen.presentation.models.BookFeaturePdfMainScreen
import com.example.main_screen.presentation.models.BookFeaturePosterMainScreen
import com.example.main_screen.presentation.models.BooksMainScreenFeatureModelUi
import javax.inject.Inject

class BookMainScreenFeatureModelToUiMapper @Inject constructor():
    Mapper<BookMainScreenFeatureModel, BooksMainScreenFeatureModelUi> {
    override fun map(from: BookMainScreenFeatureModel) = from.run {
        BooksMainScreenFeatureModelUi(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            bookDescription = bookDescription,
            book = BookFeaturePdfMainScreen(name = book.name, type = book.type, url = book.url),
            poster = BookFeaturePosterMainScreen(name = poster.name, type = poster.type, url = poster.url),
            createdAt = createdAt,
            pages = pages,
            publicYear = publicYear,
            bookFormat = bookFormat,
        )
    }
}