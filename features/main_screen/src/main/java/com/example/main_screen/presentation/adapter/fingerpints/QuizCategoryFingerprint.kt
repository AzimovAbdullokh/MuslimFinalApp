package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemTestBinding
import com.example.main_screen.presentation.models.adapter_models.CategoryFeatureAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage

class QuizCategoryFingerprint :
    ItemFingerprint<ItemTestBinding, CategoryFeatureAdapterModel> {

    override fun isRelativeItem(item: Item) = item is CategoryFeatureAdapterModel

    override fun getLayoutId() = R.layout.item_test

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemTestBinding, CategoryFeatureAdapterModel> {
        val binding = ItemTestBinding.inflate(layoutInflater, parent, false)
        return QuizViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<CategoryFeatureAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: CategoryFeatureAdapterModel,
            newItem: CategoryFeatureAdapterModel,
        ) = oldItem.id() == newItem.id()

        override fun areContentsTheSame(
            oldItem: CategoryFeatureAdapterModel,
            newItem: CategoryFeatureAdapterModel,
        ) = oldItem == newItem
    }
}

class QuizViewHolder(
    binding: ItemTestBinding,
) : BaseViewHolder<ItemTestBinding, CategoryFeatureAdapterModel>(binding) {

    override fun onBind(item: CategoryFeatureAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        cover.context.showImage(item.testCategories.poster.url, cover)
        categoryTitle.text = item.testCategories.titles
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.categoryItemOnCLick(item.testCategories.type)
        }
    }
}