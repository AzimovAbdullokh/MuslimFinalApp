package com.example.main_screen.all_books_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemBookMainScreenBinding
import com.example.main_screen.presentation.models.adapter_models.BookMainScreenAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage
import com.example.utils_core.extensions.startSlideInLeftAnim

class AllBooksFingerprint : ItemFingerprint<ItemBookMainScreenBinding, BookMainScreenAdapterModel> {

    override fun isRelativeItem(item: Item) = item is BookMainScreenAdapterModel

    override fun getLayoutId() = R.layout.item_book_main_screen

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemBookMainScreenBinding, BookMainScreenAdapterModel> {
        val binding = ItemBookMainScreenBinding.inflate(layoutInflater, parent, false)
        return AllBooksViewHolder(binding)
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

class AllBooksViewHolder(
    binding: ItemBookMainScreenBinding,
) : BaseViewHolder<ItemBookMainScreenBinding, BookMainScreenAdapterModel>(binding) {

    override fun onBind(item: BookMainScreenAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        container.startSlideInLeftAnim()
        bookPoster.context.showImage(item.posterUrl, bookPoster)
        title.text = item.bookTitle
        publicYearText.text = item.publicYear
        formatText.text = item.format
        pagesText.text = item.pages
        author.text = item.bookAuthor
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.bookItemOnClick(item.id)
        }
    }
}