package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.repositories.BookRepository
import com.example.main_screen.domain.models.books.BookFeatureModel
import com.example.main_screen.domain.repository.BookFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterBooksFeatureRepository @Inject constructor(
    private val bookRepository: BookRepository,
    private val bookDomainToBookModuleDomainMapper: Mapper<BookDomain, BookFeatureModel>,
) : BookFeatureRepository {


    override fun fetchAllBooks(id: String): Flow<List<BookFeatureModel>> =
        bookRepository.fetchAllBooks(id = id)
            .map { book -> book.map(bookDomainToBookModuleDomainMapper::map) }


    override fun fetchAllBooksFromCache(): Flow<List<BookFeatureModel>> =
        bookRepository.fetchAllBooksFromCache()
            .map { book -> book.map(bookDomainToBookModuleDomainMapper::map) }


    override fun fetchBookObservable(bookId: String): Flow<BookFeatureModel> =
        bookRepository.fetchBookObservable(bookId = bookId)
            .map(bookDomainToBookModuleDomainMapper::map)


    override suspend fun fetchBooksFromCacheById(booksId: String): BookFeatureModel{
        val bookId = bookRepository.fetchBooksFromCacheById(booksId = booksId)
        return bookDomainToBookModuleDomainMapper.map(bookId)
    }

    override suspend fun clearTable() {
        bookRepository.clearTable()
    }
}