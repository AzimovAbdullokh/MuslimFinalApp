package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.books.BookDomain
import kotlinx.coroutines.flow.Flow

interface BookRepository{


    fun fetchAllBooks(): Flow<List<BookDomain>>

    fun fetchAllBooksFromCache(): Flow<List<BookDomain>>

    fun fetchBookObservable(bookId: String): Flow<BookDomain>

    suspend fun fetchBooksFromCacheById(booksId: String): BookDomain

    suspend fun clearTable()
}