package com.example.alarms.presentation.adapter.block_fingerprints

import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.R
import com.example.alarms.databinding.MainScreenAudioNasheedBlockItemBinding
import com.example.alarms.databinding.MasalahViewPagerNasheedBlockItemBinding
import com.example.alarms.presentation.adapter.items.MainScreenAudioNasheedsBlockItem
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.utils_core.snap.OnSnapPositionChangeListener

class MasalahViewPagerBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MasalahViewPagerNasheedBlockItemBinding, MainScreenAudioNasheedsBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenAudioNasheedsBlockItem

    override fun getLayoutId() = R.layout.masalah_view_pager_nasheed_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MasalahViewPagerNasheedBlockItemBinding, MainScreenAudioNasheedsBlockItem> {
        val binding = MasalahViewPagerNasheedBlockItemBinding.inflate(layoutInflater)
        return MasalahBlockViewHolder(binding, fingerprintsList, viewPool)
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

class MasalahBlockViewHolder(
    binding: MasalahViewPagerNasheedBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MasalahViewPagerNasheedBlockItemBinding, MainScreenAudioNasheedsBlockItem>(binding),
    OnSnapPositionChangeListener {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.verticalRecyclerView) {
            adapter = fingerprintAdapter
//            layoutManager = PeekingLinearLayoutManager(itemView.context)
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainScreenAudioNasheedsBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        verticalRecyclerView.restoreState(item.state)
    }

    override fun onViewDetached() {
        binding.verticalRecyclerView.onFlingListener = null
        item.state = binding.verticalRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

    override fun onSnapPositionChange(position: Int) {
        Log.i("Azimovv","position = $position")
    }

}