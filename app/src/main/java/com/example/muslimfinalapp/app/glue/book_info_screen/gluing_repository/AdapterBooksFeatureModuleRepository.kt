package com.example.muslimfinalapp.app.glue.book_info_screen.gluing_repository

import com.example.book_info.domain.models.BookFeatureModelDomain
import com.example.book_info.domain.repository.BookFeatureModuleRepository
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterBooksFeatureModuleRepository @Inject constructor(
    private val bookRepository: BookRepository,
    private val bookDomainToBookModuleDomainMapper: Mapper<BookDomain, BookFeatureModelDomain>,
) : BookFeatureModuleRepository {


    override fun fetchAllBooks(): Flow<List<BookFeatureModelDomain>> =
        bookRepository.fetchAllBooks()
            .map { book -> book.map(bookDomainToBookModuleDomainMapper::map) }


    override fun fetchAllBooksFromCache(): Flow<List<BookFeatureModelDomain>> =
        bookRepository.fetchAllBooksFromCache()
            .map { book -> book.map(bookDomainToBookModuleDomainMapper::map) }


    override fun fetchBookObservable(bookId: String): Flow<BookFeatureModelDomain> =
        bookRepository.fetchBookObservable(bookId = bookId)
            .map(bookDomainToBookModuleDomainMapper::map)


    override suspend fun fetchBooksFromCacheById(booksId: String): BookFeatureModelDomain{
        val bookId = bookRepository.fetchBooksFromCacheById(booksId = booksId)
        return bookDomainToBookModuleDomainMapper.map(bookId)
    }

    override suspend fun clearTable() {
        bookRepository.clearTable()
    }
}