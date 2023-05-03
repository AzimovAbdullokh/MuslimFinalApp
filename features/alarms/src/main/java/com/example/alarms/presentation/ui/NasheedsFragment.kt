package com.example.alarms.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.databinding.FragmentNasheedsBinding
import com.example.alarms.presentation.adapter.block_fingerprints.MainScreenAudioNasheedBlockFingerprint
import com.example.alarms.presentation.adapter.fingerprints.AudioNasheedHorizontalFingerprint
import com.example.alarms.presentation.adapter.view_pager_adapter.ViewPagerAdapter
import com.example.alarms.presentation.ui.option_dialog.NasheedOptionDialogClickListeners
import com.example.alarms.presentation.ui.option_dialog.NasheedOptionDialogFragment
import com.example.alarms.presentation.view_pager.masalah.MasalahFragmentForViewPager
import com.example.alarms.presentation.view_pager.nasheeds.NasheedFragmentForViewPager
import com.example.alarms.presentation.view_pager.quran.QuranFragmentForViewPager
import com.example.audioservice.service_player.service_player.PlayerCallback
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.ui_core.custom.modal_page.ModalPage
import com.example.ui_core.extensions.launchWhenViewStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class NasheedsFragment :
    BaseFragment<FragmentNasheedsBinding, NasheedsFragmentViewModel>(FragmentNasheedsBinding::inflate),
    NasheedOptionDialogClickListeners {

    override val viewModel: NasheedsFragmentViewModel by viewModels()

    private val genericAdapter = FingerprintAdapter(
        listOf(
            MainScreenAudioNasheedBlockFingerprint(
                listOf(AudioNasheedHorizontalFingerprint()),
                RecyclerView.RecycledViewPool())
        )
    )
    private var playerCallback: PlayerCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        playerCallback = context as? PlayerCallback
    }

    private fun showFragmentBookOptionDialog(nashedId: String) =
        NasheedOptionDialogFragment.newInstance(nashedId = nashedId, listener = this)
            .show(requireActivity().supportFragmentManager, ModalPage.TAG)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        observeRv()
        observeData()

    }

    private fun setupViewPager() = with(binding()) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(NasheedFragmentForViewPager(), NASHEEDS)
        adapter.addFragment(MasalahFragmentForViewPager(), MASALAH)
        adapter.addFragment(QuranFragmentForViewPager(), QURAN)
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
            playAudioBookFlow.observe { playerCallback?.play(it) }
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        genericAdapter.submitList(items.first)
    }

    private fun observeRv() = with(binding()) {
        nashedsRv.adapter = genericAdapter
    }

    override fun onDetach() {
        super.onDetach()
        playerCallback = null
    }

    private companion object {
        const val NASHEEDS = "Nasheeds"
        const val MASALAH = "Masalah"
        const val QURAN = "Quran"
    }
}