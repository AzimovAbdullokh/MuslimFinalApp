package com.example.data.cloud.models.tests

import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("results") val questions: List<TestQuestionCloud>,
)

data class TestQuestionCloud(
    @SerializedName("question") val question: String,
    @SerializedName("objectId") val id: String,
    @SerializedName("a") val a: String,
    @SerializedName("b") val b: String,
    @SerializedName("c") val c: String,
    @SerializedName("d") val d: String,
    @SerializedName("answer") val answer: String,
    @SerializedName("testCategory") val testCategory: String,

)