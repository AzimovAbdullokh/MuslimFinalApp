package com.example.data.cache.source.test

import com.example.data.data.models.tests.TestQuestionData
import kotlinx.coroutines.flow.Flow

interface QuestionCacheDataSource {

    fun fetchAllQuestionsFromCacheObservable(): Flow<List<TestQuestionData>>

    suspend fun fetchAllQuestionsFromCacheSingle(): List<TestQuestionData>

    suspend fun addNewQuestionToCache(question: TestQuestionData)

    suspend fun fetchQuestionFromId(questionId: String): TestQuestionData

    suspend fun clearTable()
}