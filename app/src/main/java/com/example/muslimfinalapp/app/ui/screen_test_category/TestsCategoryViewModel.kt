package com.example.muslimfinalapp.app.ui.screen_test_category

//@HiltViewModel
//class TestsCategoryViewModel @Inject constructor(
//    private val categoryRepository: CategoryRepository,
//    private val dispatchersProvider: DispatchersProvider,
//    private val resourceProvider: ResourceProvider,
//) : BaseViewModel(), CategoryItemOnClickListener {
//
//    val allCategoriesFlow = categoryRepository.fetchAllCategories()
//        .flowOn(dispatchersProvider.io())
//        .map { categories ->
//            categories.map { category ->
//                CategoryAdapterModel(
//                    id = category.id,
//                    titles = category.titles,
//                    posterUrl = category.poster.url,
//                    listener = this
//                )
//            }
//        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
//
//}