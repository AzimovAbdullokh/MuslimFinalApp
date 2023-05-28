package com.example.data.cloud.service

import com.example.data.cloud.models.books.BookResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("classes/IslamicBooks")
    suspend fun fetchAllBooks():Response<BookResponseCloud>
}