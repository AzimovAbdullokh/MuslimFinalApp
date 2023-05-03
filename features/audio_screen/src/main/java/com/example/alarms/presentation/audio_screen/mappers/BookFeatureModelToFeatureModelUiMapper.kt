package com.example.alarms.presentation.audio_screen.mappers

import com.example.alarms.domain.models.books.BookFeatureModel
import com.example.alarms.presentation.audio_screen.models.BookFeaturePdf
import com.example.alarms.presentation.audio_screen.models.BookFeaturePoster
import com.example.alarms.presentation.audio_screen.models.BooksFeatureModelUi
import com.example.common_api.Mapper
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