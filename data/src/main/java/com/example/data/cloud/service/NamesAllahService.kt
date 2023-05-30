package com.example.data.cloud.service

import com.example.data.cloud.models.names.NamesResponseCloud
import retrofit2.Response
import retrofit2.http.GET

interface NamesAllahService {

    @GET("classes/NamesAllah")
    suspend fun fetchAllNames(): Response<NamesResponseCloud>
}