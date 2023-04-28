package com.example.data.cloud.models.category

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("results")
    var categories: List<CategoryCloud>,
)