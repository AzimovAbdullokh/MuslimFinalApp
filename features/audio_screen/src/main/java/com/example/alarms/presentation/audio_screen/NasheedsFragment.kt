package com.example.alarms.presentation.audio_screen

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.CustomPopupMenu
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.databinding.FragmentNasheedsBinding
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MainScreenAudioNasheedBlockFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.AudioNasheedHorizontalFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.HeaderFingerprint
import com.example.alarms.presentation.audio_screen.adapter.view_pager_adapter.ViewPagerAdapter
import com.example.alarms.presentation.audio_screen.option_dialog.NasheedOptionDialogClickListeners
import com.example.alarms.presentation.audio_screen.option_dialog.NasheedOptionDialogFragment
import com.example.alarms.presentation.view_pager.masalah.MasalahFragmentForViewPager
import com.example.alarms.presentation.view_pager.nasheeds.NasheedFragmentForViewPager
import com.example.alarms.presentation.view_pager.quran.QuranFragmentForViewPager
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.ui_core.custom.modal_page.ModalPage
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class NasheedsFragment :
    BaseFragment<FragmentNasheedsBinding, NasheedsFragmentViewModel>(FragmentNasheedsBinding::inflate),
    NasheedOptionDialogClickListeners {

    override val viewModel: NasheedsFragmentViewModel by viewModels()

//    private var playerCallback: PlayerCallback? = null

    private val genericAdapter =
        FingerprintAdapter(
            listOf(

                HeaderFingerprint(),
                MainScreenAudioNasheedBlockFingerprint(
                    listOf(AudioNasheedHorizontalFingerprint()),
                    RecyclerView.RecycledViewPool())

            )
        )

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        playerCallback = context as? PlayerCallback
    }

    private fun showFragmentBookOptionDialog(nashedId: String) =
        NasheedOptionDialogFragment.newInstance(nashedId = nashedId, listener = this)
            .show(requireActivity().supportFragmentManager, ModalPage.TAG)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickers()
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
//            playAudioBookFlow.observe { playerCallback?.play(it) }
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        genericAdapter.submitList(items.third)
    }

    private fun setClickers() = with(binding()) {
        toolbarBlock.addShelfBtn.setOnDownEffectClickListener(::showAddPopupMenu)
        toolbarBlock.searchBtn.setOnDownEffectClickListener { viewModel.navigateToSearchAudioFragment() }
    }

    private fun observeRv() = with(binding()) {
//        nashedsRv.adapter = genericAdapter
    }

    private fun showAddPopupMenu(view: View) {
        val popupMenu = CustomPopupMenu(context = requireContext(),
            view = view,
            gravity = Gravity.END,
            com.example.ui_core.R.style.PopupMenuDefaultStyle)

        popupMenu.menu.add(0,
            ID_ADD_SHELF_NASHEED,
            Menu.NONE,
            getString(com.example.ui_core.R.string.create_a_playlist_to_nasheeds)).apply {
            setIcon(com.example.ui_core.R.drawable.ic_audio_player)
        }

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
            }
            return@setOnMenuItemClickListener true
        }

        popupMenu.show()
    }


    override fun onDetach() {
        super.onDetach()
//        playerCallback = null
    }

    private companion object {
        private const val ID_ADD_SHELF_QURAN = 1
        private const val ID_ADD_SHELF_NASHEED = 2
        private const val ID_ADD_SHELF_MASALAH = 3

        const val NASHEEDS = "Nasheeds"
        const val MASALAH = "Masalah"
        const val QURAN = "Quran"
    }
}
