package com.example.main_quran.presentation

import androidx.lifecycle.viewModelScope
import com.example.common_api.DispatchersProviderInCommonApi
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import com.example.main_quran.domain.models.MainQuranItems
import com.example.main_quran.domain.usecases.FetchAllQuransUseCase
import com.example.main_quran.presentation.listener.QuranItemOnClickListener
import com.example.main_quran.presentation.mappers.MainQuranFilteredItemsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainQuranScreenViewModel @Inject constructor(
    fetchAllQuransUseCase: FetchAllQuransUseCase,
    private val mainQuranFilteredItemsMapper: MainQuranFilteredItemsMapper,
//    private val dispatchersProvider: DispatchersProvider,
    private val resourcesProvider: ResourceProvider,
) : BaseViewModel(), QuranItemOnClickListener {

    private val searchStringFlow = MutableStateFlow(String())

    val allFilteredItemsFlow =
        fetchAllQuransUseCase()
            .combine(searchStringFlow.debounce(SEARCH_DEBOUNCE))
             { items, search -> mapToAdapterModel(items, searchQuery = search) }
            .onStart {}
            .flowOn(Dispatchers.Default)
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope, SharingStarted.Lazily, null)

    private fun mapToAdapterModel(items: MainQuranItems, searchQuery:String) =
        mainQuranFilteredItemsMapper.map(
            items = items,
            quranItemOnClickListener = this,
            searchQuery = searchQuery
        )

    fun updateSearchQuery(searchString: String) = searchStringFlow.tryEmit(searchString)

    private fun handleError(exception: Throwable) {
        emitToErrorMessageFlow(resourcesProvider.fetchIdErrorMessage(exception))
    }

    override fun surahItemOnClick(surahId: String) {

    }
}