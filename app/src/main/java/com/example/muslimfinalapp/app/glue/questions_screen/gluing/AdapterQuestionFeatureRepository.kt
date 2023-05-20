package com.example.muslimfinalapp.app.glue.questions_screen.gluing

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import com.example.domain.domain.domain.repositories.QuestionRepository
import com.example.questions_screen.domain.model.TestQuestionFeatureDomain
import com.example.questions_screen.domain.repository.QuestionFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterQuestionFeatureRepository @Inject constructor(
    private val questionRepository: QuestionRepository,
    private val questionDomainToFeatureModelMapper: Mapper<TestQuestionDomain, TestQuestionFeatureDomain>,
) : QuestionFeatureRepository {

    override fun fetchAllQuestions(): Flow<List<TestQuestionFeatureDomain>> =
        questionRepository.fetchAllQuestions()
            .map { questions -> questions.map(questionDomainToFeatureModelMapper::map) }
}