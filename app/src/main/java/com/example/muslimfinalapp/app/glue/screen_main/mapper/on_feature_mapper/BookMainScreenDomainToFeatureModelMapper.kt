package com.example.muslimfinalapp.app.glue.screen_main.mapper.on_feature_mapper


import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import com.example.main_screen.domain.models.books.BookPdfMainScreen
import com.example.main_screen.domain.models.books.BookPosterMainScreen
import javax.inject.Inject

class BookMainScreenDomainToFeatureModelMapper @Inject constructor() :
    Mapper<BookDomain, BookMainScreenFeatureModel> {
    override fun map(from: BookDomain) = from.run {
        BookMainScreenFeatureModel(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
            id = id,
            bookDescription = bookDescription,
            book = BookPdfMainScreen(name = book.name, type = book.type, url = book.url),
            poster = BookPosterMainScreen(
                name = poster.name,
                type = poster.type,
                url = poster.url,
            ),
            createdAt = createdAt,
            publicYear = publicYear,
            pages = pages,
            bookFormat = bookFormat,
        )
    }
}