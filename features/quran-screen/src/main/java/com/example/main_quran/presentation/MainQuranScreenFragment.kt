package com.example.main_quran.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.main_quran.databinding.FragmentMainQuranScreenBinding
import com.example.main_quran.presentation.adapter.base.MainScreenQuranBlockFingerprint
import com.example.main_quran.presentation.adapter.fingerprints.QuranFingerPrint
import com.example.main_quran.presentation.adapter.items.MainScreenQuranBlockItem
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.setupTextSize
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class MainQuranScreenFragment :
    BaseFragment<FragmentMainQuranScreenBinding, MainQuranScreenViewModel>(
        FragmentMainQuranScreenBinding::inflate), android.widget.SearchView.OnQueryTextListener {

    override val viewModel: MainQuranScreenViewModel by viewModels()

    private val genericAdapter = FingerprintAdapter(
        listOf(

            MainScreenQuranBlockFingerprint(
                listOf(QuranFingerPrint()),
                RecyclerView.RecycledViewPool()
            )
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickers()
        observeRv()
        observeData()
    }

    private fun setupClickers() = with(binding()) {
        upButton.setOnDownEffectClickListener { viewModel.navigateBack() }
        searchView.setupTextSize()
        searchView.setOnQueryTextListener(this@MainQuranScreenFragment)
        val hint = getString(com.example.ui_core.R.string.title_of_the_book_name_of_the_author_or_user)
        searchView.queryHint = hint
    }


    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        genericAdapter.submitList(items.first)
    }

    private fun observeRv() = with(binding()) {
        surahRV.adapter = genericAdapter
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