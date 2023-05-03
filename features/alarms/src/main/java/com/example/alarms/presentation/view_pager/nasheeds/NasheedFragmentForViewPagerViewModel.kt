package com.example.alarms.presentation.view_pager.nasheeds

import androidx.lifecycle.viewModelScope
import com.example.alarms.domain.models.MainNasheedItems
import com.example.alarms.domain.usecases.FetchAllNasheedsUseCase
import com.example.alarms.presentation.listeners.NasheedItemOnClickListener
import com.example.alarms.presentation.mappers.MainNasheedFilteredItemsMapper
import com.example.common_api.DispatchersProvider
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class NasheedFragmentForViewPagerViewModel @Inject constructor(
    fetchAllNasheedsUseCase: FetchAllNasheedsUseCase,
    private val mainNasheedFilteredItemsMapper: MainNasheedFilteredItemsMapper,
    private val dispatchersProvider: DispatchersProvider,
    private val resourceProvider: ResourceProvider,
) : BaseViewModel(), NasheedItemOnClickListener {

    private val _playAudioBookFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val playAudioBookFlow get() = _playAudioBookFlow.asSharedFlow()

    private val _showConfirmDialogFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val showConfirmDialogFlow get() = _showConfirmDialogFlow.asSharedFlow()

    val allFilteredItemsFlow =
        fetchAllNasheedsUseCase()
            .map { items -> mapToAdapterModel(items) }
            .onStart {}
            .flowOn(dispatchersProvider.default())
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope, SharingStarted.Lazily, null)

    private fun mapToAdapterModel(items: MainNasheedItems) =
        mainNasheedFilteredItemsMapper.map(items = items, nasheedsItemOnClickListener = this)

    private fun handleError(exception: Throwable) {
        emitToErrorMessageFlow(resourceProvider.fetchIdErrorMessage(exception))
    }

    override fun nasheedItemOnClick(nasheedId: String) {
        _playAudioBookFlow.tryEmit(nasheedId)
    }

    override fun nasheedMoreBtnOnClick(id: String) {
        _showConfirmDialogFlow.tryEmit(id)
    }
}
