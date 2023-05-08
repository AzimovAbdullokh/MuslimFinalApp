package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemCommunityBinding
import com.example.main_screen.presentation.adapter.items.CommunityItem
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.squareup.picasso.Picasso


class CollectionsFingerprint : ItemFingerprint<ItemCommunityBinding, CommunityItem> {

    override fun isRelativeItem(item: Item) = item is CommunityItem

    override fun getLayoutId() = R.layout.item_community

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemCommunityBinding, CommunityItem> {
        val binding = ItemCommunityBinding.inflate(layoutInflater, parent, false)
        return CollectionViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<CommunityItem>() {

        override fun areItemsTheSame(
            oldItem: CommunityItem,
            newItem: CommunityItem,
        ) = oldItem.community.title == newItem.community.title

        override fun areContentsTheSame(
            oldItem: CommunityItem,
            newItem: CommunityItem,
        ) = oldItem == newItem
    }

}

class CollectionViewHolder(
    binding: ItemCommunityBinding,
) : BaseViewHolder<ItemCommunityBinding, CommunityItem>(binding) {

    override fun onBind(item: CommunityItem) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        Glide
            .with(itemView.context)
            .load(item.community.imageView)
            .into(cover)
        title.text = itemView.context.getText(item.community.title.id)
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener { item.listener.collectionItemOnClick(item.community) }
//        goFragmentBtn.setOnDownEffectClickListener {}

    }

}

