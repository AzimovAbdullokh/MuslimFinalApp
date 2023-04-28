package com.example.main_screen.presentation.adapter.block_fingerprints

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.presentation.adapter.items.MainScreenCommunityBlockItem
import com.example.ui_core.extensions.toDp

class MainScreenCollectionsBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool(),
) : ItemFingerprint<com.example.main_screen.databinding.MainScreenCommunityBlockBinding, MainScreenCommunityBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenCommunityBlockItem

    override fun getLayoutId() = R.layout.main_screen_community_block

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<com.example.main_screen.databinding.MainScreenCommunityBlockBinding, MainScreenCommunityBlockItem> {
        val binding = com.example.main_screen.databinding.MainScreenCommunityBlockBinding.inflate(layoutInflater)
        val newLayoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        newLayoutParams.setMargins(4.toDp, 8.toDp, 8.toDp, 16.toDp)
        binding.root.layoutParams = newLayoutParams
        return MainScreenCollectionsBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<MainScreenCommunityBlockItem>() {

        override fun areItemsTheSame(
            oldItem: MainScreenCommunityBlockItem,
            newItem: MainScreenCommunityBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainScreenCommunityBlockItem,
            newItem: MainScreenCommunityBlockItem,
        ) = oldItem == newItem

    }

}

class MainScreenCollectionsBlockViewHolder(
    binding: com.example.main_screen.databinding.MainScreenCommunityBlockBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<com.example.main_screen.databinding.MainScreenCommunityBlockBinding, MainScreenCommunityBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.recyclerView) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainScreenCommunityBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        recyclerView.apply {
//            startSlideInLeftAnim()
            restoreState(item.state)
        }
    }

    override fun onViewDetached() {
        binding.recyclerView.onFlingListener = null
        item.state = binding.recyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }
}