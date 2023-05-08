package test_screen.test_category_screen.domain.usecase

import com.example.common_api.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import test_screen.test_category_screen.domain.models.MainTestCategoryItems
import test_screen.test_category_screen.domain.repository.CategoryFeatureRepository
import javax.inject.Inject

class FetchAllCategoriesUseCaseImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProvider,
    categoryFeatureRepository: CategoryFeatureRepository,
) : FetchAllCategoriesUseCase {

    override fun invoke(): Flow<MainTestCategoryItems> = combine(
        categoryFlow,
        categoryFlowSecond
    ) { category, categorySecond ->
        MainTestCategoryItems(
            testCategories = category
        )
    }

    private val categoryFlow =
        categoryFeatureRepository.fetchAllCategories().flowOn(dispatchersProvider.io())

    private val categoryFlowSecond =
        categoryFeatureRepository.fetchAllCategories().flowOn(dispatchersProvider.io())
}