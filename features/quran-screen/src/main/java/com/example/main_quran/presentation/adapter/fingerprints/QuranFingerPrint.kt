package com.example.main_quran.presentation.adapter.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_quran.R
import com.example.main_quran.databinding.ItemSurahBinding
import com.example.main_quran.presentation.models.QuranAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.startSlideInLeftAnim

class QuranFingerPrint :
    ItemFingerprint<ItemSurahBinding, QuranAdapterModel> {

    override fun isRelativeItem(item: Item) = item is QuranAdapterModel

    override fun getLayoutId() = R.layout.item_surah

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemSurahBinding, QuranAdapterModel> {
        val binding = ItemSurahBinding.inflate(layoutInflater, parent, false)
        return SurahViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<QuranAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: QuranAdapterModel,
            newItem: QuranAdapterModel,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: QuranAdapterModel,
            newItem: QuranAdapterModel,
        ) = oldItem == newItem
    }
}


class SurahViewHolder(
    binding: ItemSurahBinding,
) : BaseViewHolder<ItemSurahBinding, QuranAdapterModel>(binding) {

    override fun onBind(item: QuranAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        surah.startSlideInLeftAnim()
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

