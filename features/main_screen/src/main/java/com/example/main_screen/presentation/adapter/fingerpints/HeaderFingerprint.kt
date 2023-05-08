package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.presentation.adapter.items.HeaderItem
import com.example.ui_core.databinding.ItemHeaderBinding
import com.example.ui_core.extensions.setPointBackground
import com.example.utils_core.extensions.setOnDownEffectClickListener

class HeaderFingerprint : ItemFingerprint<ItemHeaderBinding, HeaderItem> {

    override fun isRelativeItem(item: Item) = item is HeaderItem

    override fun getLayoutId() = com.example.ui_core.R.layout.item_header

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): HeaderViewHolder {

        val binding = ItemHeaderBinding.inflate(layoutInflater, parent, false)
        return HeaderViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<HeaderItem>() {

        override fun areItemsTheSame(oldItem: HeaderItem, newItem: HeaderItem) = true

        override fun areContentsTheSame(oldItem: HeaderItem, newItem: HeaderItem) = true
    }

}

class HeaderViewHolder(
    binding: ItemHeaderBinding,
) : BaseViewHolder<ItemHeaderBinding, HeaderItem>(binding) {

    override fun onBind(item: HeaderItem) {
        super.onBind(item)
        with(binding) {
            seeMore.isVisible = item.showMoreIsVisible
            title.text = item.titleId.format(title.context)
            if (item.showMoreIsVisible) root.setOnDownEffectClickListener { item.onClickListener() }
            circle.setPointBackground(true)
        }
    }
}
