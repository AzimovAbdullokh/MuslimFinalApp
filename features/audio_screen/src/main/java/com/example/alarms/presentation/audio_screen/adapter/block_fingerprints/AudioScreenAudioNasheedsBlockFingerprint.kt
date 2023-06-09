package com.example.alarms.presentation.audio_screen.adapter.block_fingerprints

import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.R
import com.example.alarms.databinding.MainScreenAudioNasheedBlockItemBinding
import com.example.alarms.presentation.audio_screen.adapter.items.MainScreenAudioNasheedsBlockItem
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
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
) : BaseViewHolder<MainScreenAudioNasheedBlockItemBinding, MainScreenAudioNasheedsBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.horizontalRecyclerView) {
            adapter = fingerprintAdapter
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
    }

    override fun onViewDetached() {
        binding.horizontalRecyclerView.onFlingListener = null
        item.state = binding.horizontalRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

}