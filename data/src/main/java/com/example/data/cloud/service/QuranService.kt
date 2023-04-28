package com.example.data.cloud.service

import com.example.data.cloud.models.surah.SurahResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuranService {

    @GET("classes/Quran")
    suspend fun fetchAllSurah(
        @Query("where") id: String,
    ):Response<SurahResponseCloud>
}