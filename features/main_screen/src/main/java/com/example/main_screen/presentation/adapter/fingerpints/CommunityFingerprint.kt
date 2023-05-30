package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.IncludeFunctionsBlockBinding
import com.example.main_screen.presentation.adapter.items.CommunityItem
import com.example.utils_core.extensions.setOnDownEffectClickListener


class CollectionsFingerprint : ItemFingerprint<IncludeFunctionsBlockBinding, CommunityItem> {

    override fun isRelativeItem(item: Item) = item is CommunityItem

    override fun getLayoutId() = R.layout.include_functions_block

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<IncludeFunctionsBlockBinding, CommunityItem> {
        val binding = IncludeFunctionsBlockBinding.inflate(layoutInflater, parent, false)
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
    binding: IncludeFunctionsBlockBinding,
) : BaseViewHolder<IncludeFunctionsBlockBinding, CommunityItem>(binding) {

    override fun onBind(item: CommunityItem) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        Glide
            .with(itemView.context)
            .load(item.community.imageView)
            .into(coverFunction)
        titleFunction.text = itemView.context.getText(item.community.title.id)
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener { item.listener.collectionItemOnClick(item.community) }
//        goFragmentBtn.setOnDownEffectClickListener {}

    }

}

