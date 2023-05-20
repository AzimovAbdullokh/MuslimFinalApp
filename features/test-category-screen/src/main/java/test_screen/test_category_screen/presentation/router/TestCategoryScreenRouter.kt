package test_screen.test_category_screen.presentation.router

import com.example.common_api.navigation.NavCommand
import test_screen.test_category_screen.presentation.models.CategoryTypes

interface TestCategoryScreenRouter {

    fun navigateToQuestionFragment(type: CategoryTypes): NavCommand
}