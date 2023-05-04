package com.example.data.cloud.service

import com.example.data.cloud.models.users.SessionTokenCloud
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {


    @PUT("users/{id}")
    suspend fun addSessionToken(
        @Header("X-Parse-Session-Token") sessionToken: String,
        @Path("id") id: String,
        @Body userSessionToken: SessionTokenCloud,
    ): Response<Unit>

}