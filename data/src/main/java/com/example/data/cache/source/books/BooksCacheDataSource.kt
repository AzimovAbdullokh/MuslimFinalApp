package com.example.data.cache.source.books

import com.example.data.cache.models.BookCache
import com.example.data.data.models.books.BookData
import kotlinx.coroutines.flow.Flow

interface BooksCacheDataSource {

    fun fetchAllBooksFromCacheObservable() : Flow<List<BookData>>

    fun fetchBookObservable(bookId: String): Flow<BookCache?>

    suspend fun fetchAllBooksFromCacheSingle(): List<BookData>

    suspend fun saveNewBookToCache(books: BookData)

    suspend fun fetchBooksFromId(bookId: String): BookData

    suspend fun clearTable()
}