package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.repositories.BookRepository
import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import com.example.main_screen.domain.repository.BookMainScreenFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class AdapterMainScreenBooksFeatureRepository @Inject constructor(
    private val bookRepository: BookRepository,
    private val bookDomainToBookModuleDomainMapper: Mapper<BookDomain, BookMainScreenFeatureModel>,
) : BookMainScreenFeatureRepository {

    override fun fetchAllBooks(): Flow<List<BookMainScreenFeatureModel>> =
        bookRepository.fetchAllBooks()
            .map { book -> book.map(bookDomainToBookModuleDomainMapper::map) }

    override fun fetchBookObservableByOne(bookId: String): Flow<BookMainScreenFeatureModel> =
        bookRepository.fetchBookObservable(bookId = bookId)
            .map(bookDomainToBookModuleDomainMapper::map)
}