package com.example.data.cloud.service

import com.example.data.cloud.models.nasheeds.NasheedsResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NasheedsService {

    @GET("classes/AudioNasheeds")
    suspend fun fetchAllNasheeds(
        @Query("where") id: String,
    ): Response<NasheedsResponseCloud>
}