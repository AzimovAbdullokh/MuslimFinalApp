package com.example.data.cloud.service

import com.example.data.cloud.models.khadisses.KhadisResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KhadisService {

    @GET("classes/Khadisses")
    suspend fun fetchAllKhadisses(
        @Query("where") id: String,
    ):Response<KhadisResponseCloud>

}