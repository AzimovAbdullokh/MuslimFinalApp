package com.example.main_screen.domain.repository

import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import kotlinx.coroutines.flow.Flow

interface BookMainScreenFeatureRepository {

    fun fetchAllBooks(): Flow<List<BookMainScreenFeatureModel>>

    fun fetchBookObservableByOne(bookId: String): Flow<BookMainScreenFeatureModel>
}