package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemReaderMainScreenBinding
import com.example.main_screen.presentation.models.adapter_models.ReadersMainAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage

class ReadersFingerprint : ItemFingerprint<ItemReaderMainScreenBinding, ReadersMainAdapterModel> {

    override fun isRelativeItem(item: Item) = item is ReadersMainAdapterModel

    override fun getLayoutId() = R.layout.item_reader_main_screen

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemReaderMainScreenBinding, ReadersMainAdapterModel> {
        val binding = ItemReaderMainScreenBinding.inflate(layoutInflater, parent, false)
        return ReaderViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<ReadersMainAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: ReadersMainAdapterModel,
            newItem: ReadersMainAdapterModel,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ReadersMainAdapterModel,
            newItem: ReadersMainAdapterModel,
        ) = oldItem == newItem
    }
}

class ReaderViewHolder(
    binding: ItemReaderMainScreenBinding,
) : BaseViewHolder<ItemReaderMainScreenBinding, ReadersMainAdapterModel>(binding) {

    override fun onBind(item: ReadersMainAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        title.text = item.readerName
        poster.context.showImage(item.posterUrl, poster)
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {}
    }

}