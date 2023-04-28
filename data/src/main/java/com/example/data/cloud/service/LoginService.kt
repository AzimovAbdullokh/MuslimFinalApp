package com.example.data.cloud.service

import com.example.data.cloud.models.users.UserCloud
import com.example.data.cloud.models.users.UserSignUpAnswerCloud
import com.example.data.cloud.models.users.UserSignUpCloud
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @POST("users")
    suspend fun signUp(
        @Header("X-Parse-Revocable-Session") session: Int = 1,
        @Body user: UserSignUpCloud,
    ): Response<UserSignUpAnswerCloud>


    @POST("login")
    suspend fun signIn(
        @Header("X-Parse-Revocable-Session") session: Int = 1,
        @Query("username") username: String,
        @Query("password") password: String,
    ): Response<UserCloud>
}