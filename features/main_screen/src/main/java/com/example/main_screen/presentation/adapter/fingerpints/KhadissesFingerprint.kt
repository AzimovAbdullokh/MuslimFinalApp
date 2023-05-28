package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemKhadisBinding
import com.example.main_screen.presentation.models.adapter_models.KhadisAdapterModel
import com.example.ui_core.extensions.setPointBackground
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage

class KhadissesFingerprint : ItemFingerprint<ItemKhadisBinding, KhadisAdapterModel> {

    override fun isRelativeItem(item: Item) = item is KhadisAdapterModel

    override fun getLayoutId() = R.layout.item_khadis

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemKhadisBinding, KhadisAdapterModel> {
        val binding = ItemKhadisBinding.inflate(layoutInflater, parent, false)
        return KhadissesViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<KhadisAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: KhadisAdapterModel,
            newItem: KhadisAdapterModel,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: KhadisAdapterModel,
            newItem: KhadisAdapterModel,
        ) = oldItem == newItem
    }
}

class KhadissesViewHolder(
    binding: ItemKhadisBinding,
) : BaseViewHolder<ItemKhadisBinding, KhadisAdapterModel>(binding) {

    override fun onBind(item: KhadisAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        titlee.text = item.title
        titleOnes.text = item.khadisSubject
        description.text = item.khadisDescription
        namazImage.context.showImage(item.namazImageUrl, namazImage)
    }

    private fun setOnClickListeners() = with(binding) {
        notify.setOnDownEffectClickListener {}
    }
}