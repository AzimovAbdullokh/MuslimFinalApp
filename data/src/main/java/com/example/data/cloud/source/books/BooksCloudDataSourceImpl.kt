package com.example.data.cloud.source.books

import com.example.data.base.ResponseHandler
import com.example.data.cloud.CloudDataRequestState
import com.example.data.cloud.mappers.BookCloudDataMapper
import com.example.data.cloud.models.books.BookCloud
import com.example.data.cloud.models.books.BookResponseCloud
import com.example.data.cloud.service.BookService
import com.example.data.data.models.books.BookData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BooksCloudDataSourceImpl @Inject constructor(
    private val service: BookService,
    private val dispatchersProvider: DispatchersProvider,
    private val bookCloudToDataMapper: BookCloudDataMapper,
    private val responseHandler: ResponseHandler,
    private val bookResponseToBookCloudMapper: Mapper<BookResponseCloud, BookCloud>,
    ) : BooksCloudDataSource {

    override fun fetchAllBooksFromCloud(): Flow<List<BookData>> =
        flow { emit(service.fetchAllBooks())}
            .flowOn(dispatchersProvider.io())
            .map { it.body() ?: BookResponseCloud(emptyList()) }
            .map { it.books }
            .map { books -> books.map { bookCloudToDataMapper.map(it) } }
            .flowOn(dispatchersProvider.default())


    override suspend fun fetchBookById(bookId: String): CloudDataRequestState<BookData> =
        responseHandler.safeApiCall { service.fetchAllBooks() }
            .map(bookResponseToBookCloudMapper)
            .map(bookCloudToDataMapper.map())
}