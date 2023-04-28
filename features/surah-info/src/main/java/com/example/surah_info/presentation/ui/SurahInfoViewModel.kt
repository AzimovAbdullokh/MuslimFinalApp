package com.example.surah_info.presentation.ui

import androidx.lifecycle.viewModelScope
import com.example.common_api.Mapper
import com.example.common_api.base.BaseViewModel
import com.example.surah_info.domain.models.SurahInfoFeatureModuleDomainModel
import com.example.surah_info.domain.repository.SurahInfoFeatureRepository
import com.example.surah_info.presentation.models.SurahInfoFeatureUiModel
import kotlinx.coroutines.flow.*

class SurahInfoViewModel(
    private val surahId: String,
    private val surahInfoFeatureRepository: SurahInfoFeatureRepository,
    private val surahInfoFeatureModelDomainToUiMapper:Mapper<SurahInfoFeatureModuleDomainModel, SurahInfoFeatureUiModel>
) : BaseViewModel() {

    private val surahIdFlow = MutableStateFlow(surahId)

     val surahFlow = surahIdFlow.flatMapLatest(surahInfoFeatureRepository::fetchBookObservable)
        .map(surahInfoFeatureModelDomainToUiMapper::map)
        .stateIn(viewModelScope, SharingStarted.Lazily, SurahInfoFeatureUiModel.unknown)

}