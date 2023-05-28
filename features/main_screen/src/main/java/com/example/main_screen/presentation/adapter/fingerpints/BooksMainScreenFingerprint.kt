package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemBookMainScreenBinding
import com.example.main_screen.databinding.ItemBookSecondBinding
import com.example.main_screen.presentation.models.adapter_models.BookMainScreenAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage

class BooksFingerprint : ItemFingerprint<ItemBookSecondBinding, BookMainScreenAdapterModel> {

    override fun isRelativeItem(item: Item) = item is BookMainScreenAdapterModel

    override fun getLayoutId() = R.layout.item_book_second

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemBookSecondBinding, BookMainScreenAdapterModel> {
        val binding = ItemBookSecondBinding.inflate(layoutInflater, parent, false)
        return BooksViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<BookMainScreenAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: BookMainScreenAdapterModel,
            newItem: BookMainScreenAdapterModel,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: BookMainScreenAdapterModel,
            newItem: BookMainScreenAdapterModel,
        ) = oldItem == newItem
    }
}

class BooksViewHolder(
    binding: ItemBookSecondBinding,
) : BaseViewHolder<ItemBookSecondBinding, BookMainScreenAdapterModel>(binding) {

    override fun onBind(item: BookMainScreenAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        bookPoster.context.showImage(item.posterUrl, bookPoster)
//        title.text = item.bookTitle
//        description.text = item.bookDescription
//        author.text = item.bookAuthor
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.bookItemOnClick(item.id)
        }
    }
}