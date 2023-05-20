package com.example.main_screen.presentation.adapter.block_fingerprints

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.MainScreenReadersBlockItemBinding
import com.example.main_screen.presentation.adapter.items.MainFeatureScreenReadersBlockItem

class MainScreenReadersBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainScreenReadersBlockItemBinding, MainFeatureScreenReadersBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainFeatureScreenReadersBlockItem

    override fun getLayoutId() = R.layout.main_screen_readers_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainScreenReadersBlockItemBinding, MainFeatureScreenReadersBlockItem> {
        val binding = MainScreenReadersBlockItemBinding.inflate(layoutInflater)
        return MainScreenReadersBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<MainFeatureScreenReadersBlockItem>() {

        override fun areItemsTheSame(
            oldItem: MainFeatureScreenReadersBlockItem,
            newItem: MainFeatureScreenReadersBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainFeatureScreenReadersBlockItem,
            newItem: MainFeatureScreenReadersBlockItem,
        ) = oldItem == newItem

    }

}

class MainScreenReadersBlockViewHolder(
    binding: MainScreenReadersBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainScreenReadersBlockItemBinding, MainFeatureScreenReadersBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.readerrecyclerview) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainFeatureScreenReadersBlockItem) {
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