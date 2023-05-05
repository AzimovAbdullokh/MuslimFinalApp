package com.example.alarms.presentation.search_audio_screen

import androidx.lifecycle.viewModelScope
import com.example.alarms.domain.models.MainNasheedItems
import com.example.alarms.domain.usecases.FetchAllNasheedsUseCase
import com.example.alarms.presentation.audio_screen.listeners.BookItemOnClickListener
import com.example.alarms.presentation.audio_screen.listeners.NasheedItemOnClickListener
import com.example.alarms.presentation.audio_screen.listeners.ReaderItemOnClickListener
import com.example.alarms.presentation.audio_screen.mappers.MainNasheedFilteredItemsMapper
import com.example.alarms.presentation.search_audio_screen.router.SearchFragmentRouter
import com.example.common_api.DispatchersProvider
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchAudioViewModel @Inject constructor(
    fetchAllNasheedsUseCase: FetchAllNasheedsUseCase,
    private val dispatchers: DispatchersProvider,
    private val resourceProvider: ResourceProvider,
    private val itemsMapper: MainNasheedFilteredItemsMapper,
//    private val router: SearchFragmentRouter,
) : BaseViewModel(), NasheedItemOnClickListener, BookItemOnClickListener,
    ReaderItemOnClickListener {

    private val searchStringFlow = MutableStateFlow(String())

    val allFilteredItemsFlow = fetchAllNasheedsUseCase()
        .combine(searchStringFlow.debounce(SEARCH_DEBOUNCE))
        { items, searchString -> mapToAdapterModel(items, searchString) }
            .onStart {}
            .flowOn(dispatchers.default())
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope, SharingStarted.Lazily, null)

    private fun mapToAdapterModel(items: MainNasheedItems, searchString: String) = itemsMapper.map(
        items = items,
        searchQuery = searchString,
        nasheedsItemOnClickListener = this,
        bookItemOnClickListener = this,
        readerItemOnClickListener = this,
    )

    fun updateSearchQuery(searchString: String) = searchStringFlow.tryEmit(searchString)


    private fun handleError(exception: Throwable) {
        emitToErrorMessageFlow(resourceProvider.fetchIdErrorMessage(exception))
    }

    override fun nasheedItemOnClick(nasheedId: String) {
    }

    override fun nasheedMoreBtnOnClick(id: String) {
    }

    override fun bookItemOnClick(bookId: String) {
    }

    override fun readerItemOnClick(readerId: String) {
    }

}