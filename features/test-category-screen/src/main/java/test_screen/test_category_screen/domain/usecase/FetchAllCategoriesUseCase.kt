package test_screen.test_category_screen.domain.usecase

import kotlinx.coroutines.flow.Flow
import test_screen.test_category_screen.domain.models.MainTestCategoryItems

interface FetchAllCategoriesUseCase {

    operator fun invoke(): Flow<MainTestCategoryItems>

}