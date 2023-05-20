package com.example.questions_screen.presentation.mapper

import com.example.common_api.Mapper
import com.example.questions_screen.domain.model.TestQuestionFeatureDomain
import com.example.questions_screen.presentation.model.TestQuestionFeatureUi
import javax.inject.Inject

class QuestionFeatureDomainToUiMapper @Inject constructor() :
    Mapper<TestQuestionFeatureDomain, TestQuestionFeatureUi> {
    override fun map(from: TestQuestionFeatureDomain) = from.run {
        TestQuestionFeatureUi(
                question = question,
                id = id,
                a = a,
                b = b,
                c = c,
                d = d,
                answer = answer,
                testCategory = testCategory,
        )
    }
}