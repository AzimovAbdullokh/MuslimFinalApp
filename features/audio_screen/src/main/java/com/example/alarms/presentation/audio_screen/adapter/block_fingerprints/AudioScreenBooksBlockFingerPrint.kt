package com.example.alarms.presentation.audio_screen.adapter.block_fingerprints

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.alarms.R
import com.example.alarms.databinding.AudioScreenBooksBlockItemBinding
import com.example.alarms.presentation.audio_screen.adapter.items.MainScreenBooksBlockItem
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint

class MainScreenBooksBlockFingerPrint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<AudioScreenBooksBlockItemBinding, MainScreenBooksBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenBooksBlockItem

    override fun getLayoutId() = R.layout.audio_screen_books_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<AudioScreenBooksBlockItemBinding, MainScreenBooksBlockItem> {
        val binding = AudioScreenBooksBlockItemBinding.inflate(layoutInflater)
        return MainScreenBooksBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<MainScreenBooksBlockItem>() {

        override fun areItemsTheSame(
            oldItem: MainScreenBooksBlockItem,
            newItem: MainScreenBooksBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainScreenBooksBlockItem,
            newItem: MainScreenBooksBlockItem,
        ) = oldItem == newItem

    }

}

class MainScreenBooksBlockViewHolder(
    binding: AudioScreenBooksBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<AudioScreenBooksBlockItemBinding, MainScreenBooksBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.booksRecyclerView) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: MainScreenBooksBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        booksRecyclerView.restoreState(item.state)
    }

    override fun onViewDetached() {
        binding.booksRecyclerView.onFlingListener = null
        item.state = binding.booksRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

}