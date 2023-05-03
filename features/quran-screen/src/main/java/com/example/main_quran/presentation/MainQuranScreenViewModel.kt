package com.example.main_quran.presentation

import androidx.lifecycle.viewModelScope
import com.example.common_api.DispatchersProvider
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import com.example.main_quran.domain.models.MainQuranItems
import com.example.main_quran.domain.repository.QuranFeatureRepository
import com.example.main_quran.domain.usecases.FetchAllQuransUseCase
import com.example.main_quran.presentation.listener.QuranItemOnClickListener
import com.example.main_quran.presentation.mappers.MainQuranFilteredItemsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainQuranScreenViewModel @Inject constructor(
    fetchAllQuransUseCase: FetchAllQuransUseCase,
    private val mainQuranFilteredItemsMapper: MainQuranFilteredItemsMapper,
    private val dispatchersProvider: DispatchersProvider,
    private val resourcesProvider: ResourceProvider,
    ) : BaseViewModel(), QuranItemOnClickListener {

    val allFilteredItemsFlow =
        fetchAllQuransUseCase()
            .map { items -> mapToAdapterModel(items) }
            .onStart {}
            .flowOn(dispatchersProvider.default())
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope, SharingStarted.Lazily, null)

    private fun mapToAdapterModel(items: MainQuranItems) =
        mainQuranFilteredItemsMapper.map(
            items = items,
            quranItemOnClickListener = this
        )

    private fun handleError(exception: Throwable) {
        emitToErrorMessageFlow(resourcesProvider.fetchIdErrorMessage(exception))
    }

    override fun surahItemOnClick(surahId: String) {
        TODO("Not yet implemented")
    }
}