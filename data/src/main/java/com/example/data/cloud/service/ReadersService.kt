package com.example.data.cloud.service

import com.example.data.cloud.models.readers.ReadersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ReadersService {

    @GET("classes/Readers")
    suspend fun fetchAllReaders(
        @Query("where") id: String,
    ): Response<ReadersResponse>
}