package com.example.alarms.presentation.audio_screen.adapter.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.alarms.R
import com.example.alarms.databinding.ItemReaderBinding
import com.example.alarms.presentation.audio_screen.models.adapter_models.ReadersAdapterModel
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage

class ReadersFingerprint : ItemFingerprint<ItemReaderBinding, ReadersAdapterModel> {

    override fun isRelativeItem(item: Item) = item is ReadersAdapterModel

    override fun getLayoutId() = R.layout.item_reader

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemReaderBinding, ReadersAdapterModel> {
        val binding = ItemReaderBinding.inflate(layoutInflater, parent, false)
        return ReaderViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<ReadersAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: ReadersAdapterModel,
            newItem: ReadersAdapterModel,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ReadersAdapterModel,
            newItem: ReadersAdapterModel,
        ) = oldItem == newItem
    }
}

class ReaderViewHolder(
    binding: ItemReaderBinding,
) : BaseViewHolder<ItemReaderBinding, ReadersAdapterModel>(binding) {

    override fun onBind(item: ReadersAdapterModel) {
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