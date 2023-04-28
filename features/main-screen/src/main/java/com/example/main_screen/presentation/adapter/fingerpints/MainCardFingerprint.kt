package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemMainCardBinding
import com.example.main_screen.presentation.adapter.items.MainCardItem
import com.example.utils_core.extensions.setOnDownEffectClickListener


class MainCardFingerprint :
    ItemFingerprint<ItemMainCardBinding, MainCardItem> {

    override fun isRelativeItem(item: Item) = item is MainCardItem

    override fun getLayoutId() = R.layout.item_main_card

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemMainCardBinding, MainCardItem> {
        val binding = ItemMainCardBinding.inflate(layoutInflater, parent, false)
        return AddNewBooksViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil =
        object : DiffUtil.ItemCallback<MainCardItem>() {

            override fun areItemsTheSame(
                oldItem: MainCardItem,
                newItem: MainCardItem,
            ) = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: MainCardItem,
                newItem: MainCardItem,
            ) = oldItem == newItem
        }

}

class AddNewBooksViewHolder(
    binding: ItemMainCardBinding,
) : BaseViewHolder<ItemMainCardBinding, MainCardItem>(binding) {

    override fun onBind(item: MainCardItem) {
        super.onBind(item)
        setOnClickListeners()
    }

    private fun setOnClickListeners() = with(binding) {
    }
}

