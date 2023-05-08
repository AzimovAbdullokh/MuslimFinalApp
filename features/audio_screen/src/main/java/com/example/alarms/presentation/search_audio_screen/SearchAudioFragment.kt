package com.example.alarms.presentation.search_audio_screen

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.R
import com.example.alarms.databinding.FragmentSearchAudioBinding
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MainScreenAudioNasheedBlockFingerprint
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MainScreenBooksBlockFingerPrint
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MainScreenReadersBlockFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.*
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.setupTextSize
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class SearchAudioFragment :
    BaseFragment<FragmentSearchAudioBinding, SearchAudioViewModel>(FragmentSearchAudioBinding::inflate),
    SearchView.OnQueryTextListener{

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
                    listOf(AudioNasheedHorizontalFingerprintSecond()),
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
        itemSearchView.searchHeader.setupTextSize()
        itemSearchView.searchHeader.setOnQueryTextListener(this@SearchAudioFragment)
        val hint = getString(com.example.ui_core.R.string.title_of_the_book_name_of_the_author_or_user)
        itemSearchView.searchHeader.queryHint = hint
    }

    override fun onQueryTextSubmit(searchString: String?): Boolean {
        if (searchString != null) viewModel.updateSearchQuery(searchString = searchString)
        return false
    }

    override fun onQueryTextChange(searchString: String?): Boolean {
        if (searchString != null) viewModel.updateSearchQuery(searchString = searchString)
        return false
    }
}