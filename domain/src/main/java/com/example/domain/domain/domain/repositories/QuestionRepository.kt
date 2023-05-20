package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {

    fun fetchAllQuestions(): Flow<List<TestQuestionDomain>>

    suspend fun fetchQuestionsFromCache(questionId: String): TestQuestionDomain
}