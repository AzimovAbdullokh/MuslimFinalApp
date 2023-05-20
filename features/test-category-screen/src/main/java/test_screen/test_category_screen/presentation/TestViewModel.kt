package test_screen.test_category_screen.presentation

import androidx.lifecycle.viewModelScope
import com.example.common_api.DispatchersProvider
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import test_screen.test_category_screen.domain.models.MainTestCategoryItems
import test_screen.test_category_screen.domain.usecase.FetchAllCategoriesUseCase
import test_screen.test_category_screen.presentation.listener.CategoryItemClickListener
import test_screen.test_category_screen.presentation.mappers.TestItemsFilteredMapper
import test_screen.test_category_screen.presentation.models.CategoryTypes
import test_screen.test_category_screen.presentation.router.TestCategoryScreenRouter
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    fetchAllCategoriesUseCase: FetchAllCategoriesUseCase,
    private val mainCategoryItemsFilteredMapper: TestItemsFilteredMapper,
    private val dispatchersProvider: DispatchersProvider,
    private val resourceProvider: ResourceProvider,
    private val router: TestCategoryScreenRouter,
) : BaseViewModel(), CategoryItemClickListener {

    private val searchStringFlow = MutableStateFlow(String())

    val allFilteredItemsFlow =
        fetchAllCategoriesUseCase()
            .combine(searchStringFlow.debounce(SEARCH_DEBOUNCE))
            { items, searchString -> mapToAdapterModel(items, searchString) }
            .onStart {}
            .flowOn(dispatchersProvider.default())
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope, SharingStarted.Lazily, null)

    private fun mapToAdapterModel(items: MainTestCategoryItems, searchString: String) =
        mainCategoryItemsFilteredMapper.map(
            items = items,
            searchQuery = searchString,
            categoryItemClickListener = this
        )

    fun updateSearchQuery(searchString: String) = searchStringFlow.tryEmit(searchString)


    private fun handleError(exception: Throwable) {
        emitToErrorMessageFlow(resourceProvider.fetchIdErrorMessage(exception))
    }

    override fun categoryItemOnCLick(type: CategoryTypes) {
        navigate(router.navigateToQuestionFragment(type = type))
    }
}