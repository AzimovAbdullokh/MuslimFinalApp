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
import com.example.main_screen.databinding.MainScreenKhadissesBlockItemBinding
import com.example.main_screen.presentation.adapter.items.MainScreenKhadissesBlockItem

class MainScreenKhadissesBlockFingerPrint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainScreenKhadissesBlockItemBinding, MainScreenKhadissesBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenKhadissesBlockItem

    override fun getLayoutId() = R.layout.main_screen_khadisses_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainScreenKhadissesBlockItemBinding, MainScreenKhadissesBlockItem> {
        val binding = MainScreenKhadissesBlockItemBinding.inflate(layoutInflater)
        return MainScreenKhadissesBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<MainScreenKhadissesBlockItem>() {

        override fun areItemsTheSame(
            oldItem: MainScreenKhadissesBlockItem,
            newItem: MainScreenKhadissesBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainScreenKhadissesBlockItem,
            newItem: MainScreenKhadissesBlockItem,
        ) = oldItem == newItem

    }

}

class MainScreenKhadissesBlockViewHolder(
    binding: MainScreenKhadissesBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainScreenKhadissesBlockItemBinding, MainScreenKhadissesBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.khadissesRecyclerView) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainScreenKhadissesBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        khadissesRecyclerView.restoreState(item.state)
    }

    override fun onViewDetached() {
        binding.khadissesRecyclerView.onFlingListener = null
        item.state = binding.khadissesRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

}