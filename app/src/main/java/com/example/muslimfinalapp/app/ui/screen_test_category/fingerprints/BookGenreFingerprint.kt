package com.example.muslimfinalapp.app.ui.screen_test_category.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.muslimfinalapp.R
import com.example.muslimfinalapp.app.ui.screen_test_category.model.CategoryAdapterModel
import com.example.muslimfinalapp.app.utils.extensions.setOnDownEffectClickListener
import com.example.muslimfinalapp.app.utils.extensions.showImage
import com.example.muslimfinalapp.app.utils.extensions.startSlideInLeftAnim
import com.example.muslimfinalapp.databinding.ItemCategoryBinding


class BookGenreFingerprint : ItemFingerprint<ItemCategoryBinding, CategoryAdapterModel> {

    override fun isRelativeItem(item: Item) = item is CategoryAdapterModel

    override fun getLayoutId() = R.layout.item_category

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<ItemCategoryBinding, CategoryAdapterModel> {
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return BookGenreViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<CategoryAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: CategoryAdapterModel,
            newItem: CategoryAdapterModel
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: CategoryAdapterModel,
            newItem: CategoryAdapterModel
        ) = oldItem == newItem
    }
}

class BookGenreViewHolder(
    binding: ItemCategoryBinding,
) : BaseViewHolder<ItemCategoryBinding, CategoryAdapterModel>(binding) {

    override fun onBind(item: CategoryAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        container.startSlideInLeftAnim()
        itemView.context.showImage(item.posterUrl, cover)
        title.text = item.titles
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {

        }
    }

}

