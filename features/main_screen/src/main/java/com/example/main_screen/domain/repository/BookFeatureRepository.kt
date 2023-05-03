package com.example.main_screen.domain.repository

import com.example.main_screen.domain.models.books.BookFeatureModel
import kotlinx.coroutines.flow.Flow

interface BookFeatureRepository{


    fun fetchAllBooks(id: String): Flow<List<BookFeatureModel>>

    fun fetchAllBooksFromCache(): Flow<List<BookFeatureModel>>

    fun fetchBookObservable(bookId: String): Flow<BookFeatureModel>

    suspend fun fetchBooksFromCacheById(booksId: String): BookFeatureModel

    suspend fun clearTable()
}