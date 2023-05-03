package com.example.alarms.presentation.search_audio_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.databinding.FragmentSearchAudioBinding
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MainScreenAudioNasheedBlockFingerprint
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MainScreenBooksBlockFingerPrint
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MainScreenReadersBlockFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.AudioNasheedHorizontalFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.BooksFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.HeaderFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.ReadersFingerprint
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class SearchAudioFragment :
    BaseFragment<FragmentSearchAudioBinding, SearchAudioViewModel>(FragmentSearchAudioBinding::inflate) {

    override val viewModel: SearchAudioViewModel by viewModels()

    private val genericAdapter =
        FingerprintAdapter(
            listOf(

                HeaderFingerprint(),
                MainScreenReadersBlockFingerprint(
                    listOf(ReadersFingerprint()),
                    RecyclerView.RecycledViewPool()
                ),

                HeaderFingerprint(),
                MainScreenAudioNasheedBlockFingerprint(
                    listOf(AudioNasheedHorizontalFingerprint()),
                    RecyclerView.RecycledViewPool()
                ),

                HeaderFingerprint(),
                MainScreenBooksBlockFingerPrint(
                    listOf(BooksFingerprint()),
                    RecyclerView.RecycledViewPool()
                ),
            )
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeRv()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
        }
    }

    private fun observeRv() = with(binding()) {
        recyclerView.adapter = genericAdapter
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        genericAdapter.submitList(items.first)
    }

    private fun setupViews() = with(binding()) {
        upButton.setOnDownEffectClickListener { viewModel.navigateBack() }
    }
}