package com.example.alarms.presentation.audio_screen

import androidx.lifecycle.viewModelScope
import com.example.alarms.domain.models.MainNasheedItems
import com.example.alarms.domain.usecases.FetchAllNasheedsUseCase
import com.example.alarms.presentation.audio_screen.listeners.BookItemOnClickListener
import com.example.alarms.presentation.audio_screen.listeners.NasheedItemOnClickListener
import com.example.alarms.presentation.audio_screen.listeners.ReaderItemOnClickListener
import com.example.alarms.presentation.audio_screen.mappers.MainNasheedFilteredItemsMapper
import com.example.alarms.presentation.audio_screen.router.AudioScreenRouter
import com.example.common_api.DispatchersProvider
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NasheedsFragmentViewModel @Inject constructor(
    fetchAllNasheedsUseCase: FetchAllNasheedsUseCase,
    private val mainNasheedFilteredItemsMapper: MainNasheedFilteredItemsMapper,
    private val dispatchersProvider: DispatchersProvider,
    private val resourceProvider: ResourceProvider,
    private val router: AudioScreenRouter,
) : BaseViewModel(), NasheedItemOnClickListener, ReaderItemOnClickListener,
    BookItemOnClickListener {

    private val _playAudioBookFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val playAudioBookFlow get() = _playAudioBookFlow.asSharedFlow()

    val allFilteredItemsFlow =
        fetchAllNasheedsUseCase()
            .map { items -> mapToAdapterModel(items) }
            .onStart {}
            .flowOn(dispatchersProvider.default())
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope, SharingStarted.Lazily, null)

    private fun mapToAdapterModel(items: MainNasheedItems) =
        mainNasheedFilteredItemsMapper.map(items = items,
            nasheedsItemOnClickListener = this,
            bookItemOnClickListener = this,
            readerItemOnClickListener = this,
            searchQuery = String()
        )

    private fun handleError(exception: Throwable) {
        emitToErrorMessageFlow(resourceProvider.fetchIdErrorMessage(exception))
        viewModelScope.async {

        }
    }

    fun navigateToSearchAudioFragment() {
        navigate(router.navigateToSearchAudioFragment())
    }

    override fun nasheedItemOnClick(nasheedId: String) {
        _playAudioBookFlow.tryEmit(nasheedId)

    }

    override fun nasheedMoreBtnOnClick(id: String) {}
    override fun bookItemOnClick(bookId: String) {}
    override fun readerItemOnClick(readerId: String) {}
}