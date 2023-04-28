package com.example.data.cache.source.books

import com.example.data.cache.db.BookDao
import com.example.data.cache.models.BookCache
import com.example.data.data.models.books.BookData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BooksCacheDataSourceImpl @Inject constructor(
    private val dao: BookDao,
    private val dispatchersProvider: DispatchersProvider,
    private val booksDataToCacheMapper: Mapper<BookData, BookCache>,
    private val bookCacheToDataMapper: Mapper<BookCache, BookData>,
) : BooksCacheDataSource {

    override fun fetchAllBooksFromCacheObservable(): Flow<List<BookData>> =
        dao.fetchAllBooksObservable()
            .flowOn(dispatchersProvider.io())
            .map { books -> books.map(bookCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override fun fetchBookObservable(bookId: String): Flow<BookCache?> =
        dao.fetchBookObservable(bookId = bookId)
            .flowOn(dispatchersProvider.io())

    override suspend fun fetchAllBooksFromCacheSingle(): List<BookData> =
        dao.fetchAllBooksSingle().map(bookCacheToDataMapper::map)

    override suspend fun saveNewBookToCache(books: BookData) =
        dao.addNewBook(books = booksDataToCacheMapper.map(books))

    override suspend fun fetchBooksFromId(bookId: String): BookData {
        val book = dao.fetchBooksFromId(bookId)
        return bookCacheToDataMapper.map(book)
    }

    override suspend fun clearTable() {
        dao.clearTable()
    }
}