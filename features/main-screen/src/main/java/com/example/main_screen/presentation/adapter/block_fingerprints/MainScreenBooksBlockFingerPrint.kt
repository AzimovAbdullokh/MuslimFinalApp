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
import com.example.main_screen.databinding.MainScreenBooksBlockItemBinding
import com.example.main_screen.presentation.adapter.items.MainScreenBooksBlockItem

class MainScreenBooksBlockFingerPrint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainScreenBooksBlockItemBinding, MainScreenBooksBlockItem> {

    override fun isRelativeItem(item: Item) = item is MainScreenBooksBlockItem

    override fun getLayoutId() = R.layout.main_screen_books_block_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainScreenBooksBlockItemBinding, MainScreenBooksBlockItem> {
        val binding = MainScreenBooksBlockItemBinding.inflate(layoutInflater)
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
    binding: MainScreenBooksBlockItemBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainScreenBooksBlockItemBinding, MainScreenBooksBlockItem>(binding) {

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