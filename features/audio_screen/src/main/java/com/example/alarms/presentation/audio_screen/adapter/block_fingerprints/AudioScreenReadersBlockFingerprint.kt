package com.example.alarms.presentation.audio_screen.adapter.block_fingerprints

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.R
import com.example.alarms.databinding.MainScreenReadersBlockItemBinding
import com.example.alarms.presentation.audio_screen.adapter.items.MainScreenReadersBlockItem
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint

class MainScreenReadersBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainScreenReadersBlockItemBinding, MainScreenReadersBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenReadersBlockItem

    override fun getLayoutId() = R.layout.main_screen_readers_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainScreenReadersBlockItemBinding, MainScreenReadersBlockItem> {
        val binding = MainScreenReadersBlockItemBinding.inflate(layoutInflater)
        return MainScreenReadersBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<MainScreenReadersBlockItem>() {

        override fun areItemsTheSame(
            oldItem: MainScreenReadersBlockItem,
            newItem: MainScreenReadersBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainScreenReadersBlockItem,
            newItem: MainScreenReadersBlockItem,
        ) = oldItem == newItem

    }

}

class MainScreenReadersBlockViewHolder(
    binding: MainScreenReadersBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainScreenReadersBlockItemBinding, MainScreenReadersBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.readerrecyclerview) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainScreenReadersBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        readerrecyclerview.restoreState(item.state)
    }

    override fun onViewDetached() {
        binding.readerrecyclerview.onFlingListener = null
        item.state = binding.readerrecyclerview.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

}