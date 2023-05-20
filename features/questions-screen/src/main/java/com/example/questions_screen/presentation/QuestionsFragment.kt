package com.example.questions_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.questions_screen.R
import com.example.questions_screen.databinding.FragmentQuestionsBinding
import com.example.questions_screen.presentation.model.TestQuestionFeatureUi
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment :
    BaseFragment<FragmentQuestionsBinding, QuestionsViewModel>(FragmentQuestionsBinding::inflate) {

    override val viewModel: QuestionsViewModel by viewModels()

    private var index = 0
    private var answer: String = ""
    private var rightAnswer: String? = null
    private var listQuestions = mutableListOf<TestQuestionFeatureUi>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeResource()
    }

    private fun observeResource() = with(viewModel) {
        launchWhenViewStarted {
            questionFlow.observe {
                setupViews(it.single())
            }
        }
    }

    private fun setupViews(question: TestQuestionFeatureUi) = with(binding()) {
        answerBtn.setOnDownEffectClickListener{}
        btnNextTest.setOnDownEffectClickListener{}
        upButton.setOnDownEffectClickListener { viewModel.navigateBack() }
        questionText.text = question.question
        answerAButton.text = question.a
        answerBButton.text = question.b
        answerCButton.text = question.c
        answerDButton.text = question.d
        rightAnswer = question.answer
    }

    private fun checkNextQuestion() {
        index += 1
        if (index < listQuestions.size) {
            showSuccessSnackBar(message = getString(com.example.ui_core.R.string.answer_is_success))
            binding().btnPrevTest.show()
            setupViews(question = listQuestions[index])
        } else {
            showSuccessSnackBar(message = getString(com.example.ui_core.R.string.survey_is_success))
        }
    }

    private fun chekAnswer() {
        when {
            answer == "" -> showInfoSnackBar(message = "Выберите ответ")
            rightAnswer == answer -> checkNextQuestion()
            else -> {
                showErrorSnackbar(message = getString(com.example.ui_core.R.string.answer_is_error))
            }
        }
    }

    private fun restart() = binding().apply {
        answer = ""
        answerAButton.isChecked = false
        answerBButton.isChecked = false
        answerCButton.isChecked = false
        answerDButton.isChecked = false
    }


}