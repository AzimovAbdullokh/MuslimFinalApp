package com.example.muslimfinalapp.app.glue.test_screen.router

import com.example.common_api.navigation.NavCommand
import com.example.common_api.navigation.toNavCommand
import test_screen.test_category_screen.presentation.TestFragmentDirections
import test_screen.test_category_screen.presentation.models.CategoryTypes
import test_screen.test_category_screen.presentation.router.TestCategoryScreenRouter
import javax.inject.Inject

class TestCategoryScreenRouterImpl @Inject constructor(): TestCategoryScreenRouter {

    override fun navigateToQuestionFragment(type: CategoryTypes): NavCommand =
        TestFragmentDirections
            .actionTestFragmentToQuestionsFragment(type = type)
            .toNavCommand()
}