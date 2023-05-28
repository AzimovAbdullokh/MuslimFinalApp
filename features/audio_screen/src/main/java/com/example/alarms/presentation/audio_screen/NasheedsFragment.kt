package com.example.alarms.presentation.audio_screen

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.CustomPopupMenu
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.databinding.FragmentNasheedsBinding
import com.example.alarms.presentation.audio_screen.adapter.block_fingerprints.MasalahViewPagerBlockFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.AudioNasheedVerticalFingerprint
import com.example.alarms.presentation.audio_screen.adapter.fingerprints.HeaderFingerprint
import com.example.alarms.presentation.audio_screen.option_dialog.NasheedOptionDialogClickListeners
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.motion.MotionListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class NasheedsFragment :
    BaseFragment<FragmentNasheedsBinding, NasheedsFragmentViewModel>(FragmentNasheedsBinding::inflate),
    NasheedOptionDialogClickListeners {

    override val viewModel: NasheedsFragmentViewModel by viewModels()

    private val genericAdapter =
        FingerprintAdapter(
            listOf(

                HeaderFingerprint(),
                MasalahViewPagerBlockFingerprint(
                    listOf(AudioNasheedVerticalFingerprint()),
                    RecyclerView.RecycledViewPool()),
            )
        )


    private var concatAdapter: ConcatAdapter =
        ConcatAdapter(
            ConcatAdapter
                .Config
                .Builder()
                .setIsolateViewTypes(false)
                .build(),
            genericAdapter,
        )

    private val motionListener = MotionListener(::setScreenState)

    override fun onStart() {
        super.onStart()
        binding().root.progress = viewModel.motionPosition.value
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setClickers()
        observeRv()
        observeData()

    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
        }
    }

    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        genericAdapter.submitList(items.second)
    }

    private fun setClickers() = with(binding()) {
        toolbarBlock.searchBtn.setOnDownEffectClickListener { viewModel.navigateToSearchAudioFragment() }
    }

    private fun observeRv() = with(binding()) {
        nashedsRv.adapter = concatAdapter
    }

    private fun setupViews() = with(binding()) {
        root.addTransitionListener(motionListener)
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

    private companion object {
        private const val ID_ADD_SHELF_NASHEED = 2
    }
}
