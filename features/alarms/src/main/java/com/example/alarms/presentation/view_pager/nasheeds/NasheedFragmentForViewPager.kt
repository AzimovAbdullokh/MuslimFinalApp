package com.example.alarms.presentation.view_pager.nasheeds

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.databinding.FragmentNasheedFragmentForViewPagerBinding
import com.example.alarms.presentation.adapter.block_fingerprints.MasalahViewPagerBlockFingerprint
import com.example.alarms.presentation.adapter.fingerprints.AudioNasheedVerticalFingerprint
import com.example.alarms.presentation.ui.option_dialog.NasheedOptionDialogClickListeners
import com.example.alarms.presentation.ui.option_dialog.NasheedOptionDialogFragment
import com.example.audioservice.service_player.service_player.PlayerCallback
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.ui_core.custom.modal_page.ModalPage
import com.example.ui_core.extensions.launchWhenViewStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class NasheedFragmentForViewPager :
    BaseFragment<FragmentNasheedFragmentForViewPagerBinding, NasheedFragmentForViewPagerViewModel>(
        FragmentNasheedFragmentForViewPagerBinding::inflate), NasheedOptionDialogClickListeners {

    override val viewModel: NasheedFragmentForViewPagerViewModel by viewModels()

    private var playerCallback: PlayerCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        playerCallback = context as? PlayerCallback
    }

    private val genericAdapter = FingerprintAdapter(listOf(

        MasalahViewPagerBlockFingerprint(
            listOf(AudioNasheedVerticalFingerprint()),
            RecyclerView.RecycledViewPool()))

    )

    private fun showFragmentBookOptionDialog(bookId: String) =
        NasheedOptionDialogFragment.newInstance(nashedId = bookId, listener = this)
            .show(requireActivity().supportFragmentManager, ModalPage.TAG)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeRv()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
            showConfirmDialogFlow.observe(::showFragmentBookOptionDialog)
            playAudioBookFlow.observe { playerCallback?.play(it) }
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        genericAdapter.submitList(items.first)
    }

    private fun observeRv() = with(binding()) {
        nasheedaRv.adapter = genericAdapter
    }
    override fun onDetach() {
        super.onDetach()
        playerCallback = null
    }
}