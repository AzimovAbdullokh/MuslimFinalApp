package com.example.main_quran.presentation

import android.os.Bundle
import android.view.View
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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class MainQuranScreenFragment :
    BaseFragment<FragmentMainQuranScreenBinding, MainQuranScreenViewModel>(
        FragmentMainQuranScreenBinding::inflate) {

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
        observeRv()
        observeData()
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
}