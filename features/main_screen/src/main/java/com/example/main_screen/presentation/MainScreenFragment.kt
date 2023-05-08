package com.example.main_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.main_screen.databinding.FragmentMainScreenBinding
import com.example.main_screen.presentation.adapter.block_fingerprints.*
import com.example.main_screen.presentation.adapter.fingerpints.*
import com.example.main_screen.presentation.adapter.items.HeaderItem
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class MainScreenFragment :
    BaseFragment<FragmentMainScreenBinding, MainScreenViewModel>(FragmentMainScreenBinding::inflate) {

    override val viewModel: MainScreenViewModel by viewModels()

    private val genericAdapter = FingerprintAdapter(listOf(

        MainCardFingerprint(),
//            HeaderFingerprint(),
//            MainScreenReadersBlockFingerprint
//                (listOf(ReadersFingerprint()),
//                RecyclerView.RecycledViewPool()
//            ),

        MainScreenCollectionsBlockFingerprint(listOf(CollectionsFingerprint())),
//
//            HeaderFingerprint(),
//            MainScreenBooksBlockFingerPrint(
//                listOf(BooksFingerprint()),
//                RecyclerView.RecycledViewPool()
//            ),
//
//            HeaderFingerprint(),
//            MainScreenSurahBlockFingerprint(
//                listOf(SurahFingerPrint()),
//                RecyclerView.RecycledViewPool()
//            ),
//
//            HeaderFingerprint(),
//            MainScreenAudioNasheedBlockFingerprint(
//                listOf(AudioNasheedHorizontalFingerprint()),
//                RecyclerView.RecycledViewPool()
//            ),
        HeaderFingerprint(),
        MainScreenKhadissesBlockFingerPrint(
            listOf(KhadissesFingerprint()),
            RecyclerView.RecycledViewPool()
        ),
    ))

    var concatAdapter: ConcatAdapter =
        ConcatAdapter(ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
            genericAdapter)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            saveRecyclerViewCurrentState()
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
            playAudioNasheedFlow.observe { }
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        saveRecyclerViewCurrentState()
        genericAdapter.submitList(items.first) { restoreRecyclerViewCurrentState() }
    }


    private fun saveRecyclerViewCurrentState() {
        val currentState = binding().homeRv.layoutManager?.onSaveInstanceState()
        viewModel.saveRecyclerViewCurrentState(currentState)
    }

    private fun restoreRecyclerViewCurrentState() {
        val currentPosition = viewModel.fetchRecyclerViewCurrentState()
        binding().homeRv.layoutManager?.onRestoreInstanceState(currentPosition)
    }

    private fun setupRv() {
        binding().homeRv.adapter = concatAdapter
    }
}