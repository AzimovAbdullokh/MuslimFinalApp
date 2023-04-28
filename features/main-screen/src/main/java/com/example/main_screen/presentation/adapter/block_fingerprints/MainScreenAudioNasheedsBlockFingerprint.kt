package com.example.main_screen.presentation.adapter.block_fingerprints

import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.MainScreenAudioNasheedBlockItemBinding
import com.example.main_screen.presentation.adapter.items.MainScreenAudioNasheedsBlockItem
import com.example.ui_core.adapter.managers.PeekingLinearLayoutManager
import com.example.utils_core.extensions.attachSnapHelperWithListener
import com.example.utils_core.snap.OnSnapPositionChangeListener

class MainScreenAudioNasheedBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainScreenAudioNasheedBlockItemBinding, MainScreenAudioNasheedsBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenAudioNasheedsBlockItem

    override fun getLayoutId() = R.layout.main_screen_audio_nasheed_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainScreenAudioNasheedBlockItemBinding, MainScreenAudioNasheedsBlockItem> {
        val binding = MainScreenAudioNasheedBlockItemBinding.inflate(layoutInflater)
        return MainScreenAudioBookBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<MainScreenAudioNasheedsBlockItem>() {

        override fun areItemsTheSame(
            oldItem: MainScreenAudioNasheedsBlockItem,
            newItem: MainScreenAudioNasheedsBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainScreenAudioNasheedsBlockItem,
            newItem: MainScreenAudioNasheedsBlockItem,
        ) = oldItem == newItem

    }

}

class MainScreenAudioBookBlockViewHolder(
    binding: MainScreenAudioNasheedBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainScreenAudioNasheedBlockItemBinding, MainScreenAudioNasheedsBlockItem>(binding),
    OnSnapPositionChangeListener {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.horizontalRecyclerView) {
            adapter = fingerprintAdapter
            layoutManager = PeekingLinearLayoutManager(itemView.context)
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainScreenAudioNasheedsBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        horizontalRecyclerView.restoreState(item.state)
        horizontalRecyclerView.apply {
            restoreState(item.state)
            if (horizontalRecyclerView.onFlingListener != null) return@with
            attachSnapHelperWithListener(
                snapHelper = PagerSnapHelper(),
                onSnapPositionChangeListener = this@MainScreenAudioBookBlockViewHolder
            )
        }
    }

    override fun onViewDetached() {
        binding.horizontalRecyclerView.onFlingListener = null
        item.state = binding.horizontalRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

    override fun onSnapPositionChange(position: Int) {
        Log.i("Azimovv","position = $position")
    }

}