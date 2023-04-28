package com.example.data.cloud.source.books

import com.example.data.cloud.CloudDataRequestState
import com.example.data.data.models.books.BookData
import kotlinx.coroutines.flow.Flow

interface BooksCloudDataSource {

    fun fetchAllBooksFromCloud(id: String): Flow<List<BookData>>

    suspend fun fetchBookById(bookId: String): CloudDataRequestState<BookData>

}