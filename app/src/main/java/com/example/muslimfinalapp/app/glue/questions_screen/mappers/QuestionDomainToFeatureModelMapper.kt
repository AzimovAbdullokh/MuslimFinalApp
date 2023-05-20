package com.example.muslimfinalapp.app.glue.questions_screen.mappers

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import com.example.questions_screen.domain.model.TestQuestionFeatureDomain
import javax.inject.Inject

class QuestionDomainToFeatureModelMapper @Inject constructor() :
    Mapper<TestQuestionDomain, TestQuestionFeatureDomain> {
    override fun map(from: TestQuestionDomain) = from.run {
        TestQuestionFeatureDomain(
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