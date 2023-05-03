package com.example.surah_info.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common_api.Mapper
import com.example.surah_info.domain.models.SurahInfoFeatureModuleDomainModel
import com.example.surah_info.domain.repository.SurahInfoFeatureRepository
import com.example.surah_info.presentation.models.SurahInfoFeatureUiModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

const val SURAH_KEY = "SURAH_KEY"


class SurahInfoViewModelFactory @AssistedInject constructor(
    @Assisted(SURAH_KEY) private val surahId: String,
    private val surahInfoFeatureRepository: SurahInfoFeatureRepository,
    private val surahInfoFeatureModelDomainToUiMapper: Mapper<SurahInfoFeatureModuleDomainModel, SurahInfoFeatureUiModel>,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == SurahInfoViewModel::class.java)
        return SurahInfoViewModel(surahId = surahId,
            surahInfoFeatureRepository = surahInfoFeatureRepository,
            surahInfoFeatureModelDomainToUiMapper = surahInfoFeatureModelDomainToUiMapper) as T
    }

    @AssistedFactory
    interface Factory {

        fun create(@Assisted(SURAH_KEY) bookId: String): SurahInfoViewModelFactory
    }
}