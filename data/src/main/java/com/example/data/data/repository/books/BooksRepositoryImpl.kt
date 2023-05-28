package com.example.data.data.repository.books

import com.example.data.cache.models.BookCache
import com.example.data.cache.source.books.BooksCacheDataSource
import com.example.data.cloud.source.books.BooksCloudDataSource
import com.example.data.cloud.takeSuccess
import com.example.data.data.models.books.BookData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.repositories.BookRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val cloudDataSource: BooksCloudDataSource,
    private val cacheDataSource: BooksCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val bookDataToDomainMapper: Mapper<BookData, BookDomain>,
    private val bookCashMapper: Mapper<BookCache, BookData>,
) : BookRepository {

    override fun fetchAllBooks(): Flow<List<BookDomain>> =
        flow { emit(cacheDataSource.fetchAllBooksFromCacheSingle()) }
            .flatMapLatest { handleFetchBookInCache(it) }
            .map { book -> book.map(bookDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    private fun handleFetchBookInCache(
        cashedBooks: List<BookData>,
    ) = if (cashedBooks.isEmpty()) cloudDataSource.fetchAllBooksFromCloud()
        .onEach { bookData -> bookData.forEach {
            cacheDataSource.saveNewBookToCache(it)
        }
    }
    else cacheDataSource.fetchAllBooksFromCacheObservable()

    override fun fetchAllBooksFromCache(): Flow<List<BookDomain>> =
        cacheDataSource.fetchAllBooksFromCacheObservable()
            .map { books -> books.map(bookDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())

    override fun fetchBookObservable(bookId: String): Flow<BookDomain> =
        cacheDataSource.fetchBookObservable(bookId = bookId)
            .map { bookFromCache -> if (bookFromCache == null) cloudDataSource.fetchBookById(bookId = bookId)
                .takeSuccess() else bookCashMapper.map(bookFromCache) }
            .map { it ?: BookData.unknown }
            .map(bookDataToDomainMapper::map)
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchBooksFromCacheById(booksId: String): BookDomain {
        val books = cacheDataSource.fetchBooksFromId(bookId = booksId)
        return bookDataToDomainMapper.map(books)
    }

    override suspend fun clearTable() {
        cacheDataSource.clearTable()
    }
}