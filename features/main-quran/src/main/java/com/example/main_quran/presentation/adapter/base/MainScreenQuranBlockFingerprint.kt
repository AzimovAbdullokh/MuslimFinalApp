package com.example.main_quran.presentation.adapter.base

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_quran.R
import com.example.main_quran.databinding.MainScreenSurahBlockItemBinding
import com.example.main_quran.presentation.adapter.items.MainScreenQuranBlockItem

class MainScreenQuranBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainScreenSurahBlockItemBinding, MainScreenQuranBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenQuranBlockItem

    override fun getLayoutId() = R.layout.main_screen_surah_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainScreenSurahBlockItemBinding, MainScreenQuranBlockItem> {
        val binding = MainScreenSurahBlockItemBinding.inflate(layoutInflater)
        return MainScreenSurahBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<MainScreenQuranBlockItem>() {

        override fun areItemsTheSame(
            oldItem: MainScreenQuranBlockItem,
            newItem: MainScreenQuranBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainScreenQuranBlockItem,
            newItem: MainScreenQuranBlockItem,
        ) = oldItem == newItem

    }

}

class MainScreenSurahBlockViewHolder(
    binding: MainScreenSurahBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainScreenSurahBlockItemBinding, MainScreenQuranBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.surahRecyclerView) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainScreenQuranBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        surahRecyclerView.restoreState(item.state)
    }

    override fun onViewDetached() {
        binding.surahRecyclerView.onFlingListener = null
        item.state = binding.surahRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

}