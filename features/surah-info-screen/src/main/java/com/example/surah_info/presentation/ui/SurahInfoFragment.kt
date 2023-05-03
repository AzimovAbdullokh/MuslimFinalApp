package com.example.surah_info.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common_api.base.BaseFragment
import com.example.surah_info.databinding.FragmentSurahInfoBinding
import com.example.surah_info.presentation.models.SurahInfoFeatureUiModel
import com.example.ui_core.extensions.launchWhenViewStarted
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SurahInfoFragment :
    BaseFragment<FragmentSurahInfoBinding, SurahInfoViewModel>(FragmentSurahInfoBinding::inflate) {

    @Inject
    lateinit var factory: SurahInfoViewModelFactory.Factory

    override val viewModel: SurahInfoViewModel by viewModels { factory.create(bookId = "ValDRZrCyi") }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeResource()
    }

    private fun observeResource() = with(viewModel) {
        launchWhenViewStarted {
            surahFlow.observe(::handleBookFetching)
        }
    }

    private fun handleBookFetching(surah: SurahInfoFeatureUiModel) = with(binding()) {
        surahInfoToolbar.toolbarBookTitle.text = surah.surahName
        surahTv.text = surah.surah
    }

}