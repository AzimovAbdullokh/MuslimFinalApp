package com.example.questions_screen.presentation

import com.example.common_api.DispatchersProvider
import com.example.common_api.Mapper
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import com.example.questions_screen.domain.model.TestQuestionFeatureDomain
import com.example.questions_screen.domain.repository.QuestionFeatureRepository
import com.example.questions_screen.presentation.model.TestQuestionFeatureUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val testQuestionFeatureRepository: QuestionFeatureRepository,
    private val dispatchersProvider: DispatchersProvider,
    private val questionFeatureDomainToUiMapper: Mapper<TestQuestionFeatureDomain, TestQuestionFeatureUi>,
) : BaseViewModel() {

    val questionFlow = testQuestionFeatureRepository.fetchAllQuestions()
        .map { question -> question.map(questionFeatureDomainToUiMapper::map) }
        .flowOn(dispatchersProvider.default())

}