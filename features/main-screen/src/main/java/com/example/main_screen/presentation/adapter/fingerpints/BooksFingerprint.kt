package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemBookBinding
import com.example.main_screen.presentation.models.adapter_models.BookAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage

class BooksFingerprint : ItemFingerprint<ItemBookBinding, BookAdapterModel> {

    override fun isRelativeItem(item: Item) = item is BookAdapterModel

    override fun getLayoutId() = R.layout.item_book

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemBookBinding, BookAdapterModel> {
        val binding = ItemBookBinding.inflate(layoutInflater, parent, false)
        return BooksViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<BookAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: BookAdapterModel,
            newItem: BookAdapterModel,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: BookAdapterModel,
            newItem: BookAdapterModel,
        ) = oldItem == newItem
    }
}

class BooksViewHolder(
    binding: ItemBookBinding,
) : BaseViewHolder<ItemBookBinding, BookAdapterModel>(binding) {

    override fun onBind(item: BookAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        bookPoster.context.showImage(item.posterUrl, bookPoster)
        title.text = item.bookTitle
        author.text = item.bookAuthor
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.bookItemOnClick(item.id)
        }
    }
}