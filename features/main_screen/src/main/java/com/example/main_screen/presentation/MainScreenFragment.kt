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
import com.example.main_screen.presentation.MainScreenViewModel_Factory.newInstance
import com.example.main_screen.presentation.adapter.block_fingerprints.*
import com.example.main_screen.presentation.adapter.fingerpints.*
import com.example.main_screen.presentation.adapter.items.HeaderItem
import com.example.main_screen.presentation.option_dialog.BookOptionDialogClickListeners
import com.example.main_screen.presentation.option_dialog.BookOptionDialogFragment
import com.example.ui_core.custom.modal_page.ModalPage
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.motion.MotionListener
import com.example.utils_core.motion.MotionState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class MainScreenFragment :
    BaseFragment<FragmentMainScreenBinding, MainScreenViewModel>(FragmentMainScreenBinding::inflate),
    BookOptionDialogClickListeners {

    override val viewModel: MainScreenViewModel by viewModels()

    private val genericAdapter = FingerprintAdapter(
        listOf(

            MainScreenReadersBlockFingerprint
                (listOf(ReadersFingerprint()),
                RecyclerView.RecycledViewPool()
            ),

            HeaderFingerprint(),
            MainScreenBooksBlockFingerPrint(
                listOf(BooksFingerprint()),
                RecyclerView.RecycledViewPool()
            ),

            HeaderFingerprint(),
            MainScreenKhadissesBlockFingerPrint(
                listOf(KhadissesFingerprint()),
                RecyclerView.RecycledViewPool()
            ),

            HeaderFingerprint(),
            QuizCategoryBlockFingerprint(
                listOf(QuizCategoryFingerprint()),
                RecyclerView.RecycledViewPool()
            )
        ))

    var concatAdapter: ConcatAdapter =
        ConcatAdapter(
            ConcatAdapter
                .Config
                .Builder()
                .setIsolateViewTypes(false)
                .build(),
            genericAdapter
        )

    private val motionListener = MotionListener(::setScreenState)

    private fun showFragmentBookOptionDialog(bookId: String) =
        BookOptionDialogFragment.newInstance(nashedId = bookId, listener = this)
            .show(requireActivity().supportFragmentManager, ModalPage.TAG)

    override fun onStart() {
        super.onStart()
        binding().root.progress = viewModel.motionPosition.value
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupRv()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            saveRecyclerViewCurrentState()
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
            playAudioNasheedFlow.observe { }
            showConfirmDialogFlow.observe(::showFragmentBookOptionDialog)
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        saveRecyclerViewCurrentState()
        genericAdapter.submitList(items.first) { restoreRecyclerViewCurrentState() }
    }


    private fun saveRecyclerViewCurrentState() {
        val currentState =
            binding().includeMainCardBlock.homeRv.layoutManager?.onSaveInstanceState()
        viewModel.saveRecyclerViewCurrentState(currentState)
    }

    private fun restoreRecyclerViewCurrentState() {
        val currentPosition = viewModel.fetchRecyclerViewCurrentState()
        binding().includeMainCardBlock.homeRv.layoutManager?.onRestoreInstanceState(currentPosition)
    }

    private fun setupRv() {
        binding().includeMainCardBlock.homeRv.adapter = concatAdapter
    }

    private fun setupViews() = with(binding()) {
        root.addTransitionListener(motionListener)
    }
}