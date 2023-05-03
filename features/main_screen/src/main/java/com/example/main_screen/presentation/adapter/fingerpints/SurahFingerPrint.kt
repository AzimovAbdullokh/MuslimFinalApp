package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemSurahBinding
import com.example.main_screen.presentation.models.adapter_models.SurahAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener

class SurahFingerPrint :
    ItemFingerprint<ItemSurahBinding, SurahAdapterModel> {

    override fun isRelativeItem(item: Item) = item is SurahAdapterModel

    override fun getLayoutId() = R.layout.item_surah

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemSurahBinding, SurahAdapterModel> {
        val binding = ItemSurahBinding.inflate(layoutInflater, parent, false)
        return SurahViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<SurahAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: SurahAdapterModel,
            newItem: SurahAdapterModel,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: SurahAdapterModel,
            newItem: SurahAdapterModel,
        ) = oldItem == newItem
    }
}


class SurahViewHolder(
    binding: ItemSurahBinding,
) : BaseViewHolder<ItemSurahBinding, SurahAdapterModel>(binding) {

    override fun onBind(item: SurahAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        tvSurahNum.text = item.surahCountInQuran
        tvSurahName.text = item.surahName
        tvSurahArabicName.text = item.surahArabName
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.surahItemOnClick(item.surahId)
        }

        readIcon.setOnDownEffectClickListener {
            item.listener.surahItemOnClick(item.surahId)
        }
    }
}

