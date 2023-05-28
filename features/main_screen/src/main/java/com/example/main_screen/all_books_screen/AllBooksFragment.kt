package com.example.main_screen.all_books_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.main_screen.all_books_screen.adapter.AllBooksFingerprint
import com.example.main_screen.all_books_screen.adapter.MainScreenAllBooksBlockFingerPrint
import com.example.main_screen.databinding.FragmentAllBooksBinding
import com.example.main_screen.presentation.MainScreenViewModel
import com.example.main_screen.presentation.adapter.block_fingerprints.MainScreenBooksBlockFingerPrint
import com.example.main_screen.presentation.adapter.fingerpints.BooksFingerprint
import com.example.main_screen.presentation.adapter.fingerpints.HeaderFingerprint
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class AllBooksFragment :
    BaseFragment<FragmentAllBooksBinding, MainScreenViewModel>(FragmentAllBooksBinding::inflate) {

    override val viewModel: MainScreenViewModel by viewModels()

    private val genericAdapter = FingerprintAdapter(listOf(

        MainScreenAllBooksBlockFingerPrint(
            listOf(AllBooksFingerprint()),
            RecyclerView.RecycledViewPool()),

        ))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvAndClick()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            saveRecyclerViewCurrentState()
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        saveRecyclerViewCurrentState()
        genericAdapter.submitList(items.second) { restoreRecyclerViewCurrentState() }
    }

    private fun saveRecyclerViewCurrentState() {
        val currentState = binding().allBooksRv.layoutManager?.onSaveInstanceState()
        viewModel.saveRecyclerViewCurrentState(currentState)
    }

    private fun restoreRecyclerViewCurrentState() {
        val currentPosition = viewModel.fetchRecyclerViewCurrentState()
        binding().allBooksRv.layoutManager?.onRestoreInstanceState(currentPosition)
    }

    private fun setupRvAndClick() {
        binding().allBooksRv.adapter = genericAdapter
        binding().upButton.setOnDownEffectClickListener { viewModel.navigateBack() }
    }

}