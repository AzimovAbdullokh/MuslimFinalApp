package com.example.data.cloud.service

import com.example.data.cloud.models.category.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("classes/Category")
    suspend fun fetchAllCategories(): Response<CategoryResponse>
}