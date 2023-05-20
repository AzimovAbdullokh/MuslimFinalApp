package com.example.data.cloud.service

import com.example.data.cloud.models.category.CategoryResponse
import com.example.data.cloud.models.tests.TestResponse
import retrofit2.Response
import retrofit2.http.GET

interface TestCategoryService {

    @GET("classes/Category")
    suspend fun fetchAllCategories(): Response<CategoryResponse>

    @GET("classes/Tests")
    suspend fun fetchAllTests(): Response<TestResponse>
}