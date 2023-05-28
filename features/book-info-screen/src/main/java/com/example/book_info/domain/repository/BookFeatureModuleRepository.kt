package com.example.book_info.domain.repository

import com.example.book_info.domain.models.BookFeatureModelDomain
import kotlinx.coroutines.flow.Flow

interface BookFeatureModuleRepository{


    fun fetchAllBooks(): Flow<List<BookFeatureModelDomain>>

    fun fetchAllBooksFromCache(): Flow<List<BookFeatureModelDomain>>

    fun fetchBookObservable(bookId: String): Flow<BookFeatureModelDomain>

    suspend fun fetchBooksFromCacheById(booksId: String): BookFeatureModelDomain

    suspend fun clearTable()
}