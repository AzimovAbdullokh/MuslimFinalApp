package com.example.questions_screen.domain.repository

import com.example.questions_screen.domain.model.TestQuestionFeatureDomain
import kotlinx.coroutines.flow.Flow

interface QuestionFeatureRepository {

    fun fetchAllQuestions(): Flow<List<TestQuestionFeatureDomain>>

//    suspend fun fetchQuestionsFromCache(questionId: String): TestQuestionFeatureDomain
}