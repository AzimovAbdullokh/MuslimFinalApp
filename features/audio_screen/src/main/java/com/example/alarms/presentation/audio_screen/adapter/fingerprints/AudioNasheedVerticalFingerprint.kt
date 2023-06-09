package com.example.alarms.presentation.audio_screen.adapter.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.alarms.R
import com.example.alarms.databinding.ItemPagerNasheedsBinding
import com.example.alarms.presentation.audio_screen.models.adapter_models.AudioNasheedAdapterModel
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage
import com.example.utils_core.extensions.startSlideInBottomtAnim
import com.example.utils_core.extensions.startSlideInLeftAnim

class AudioNasheedVerticalFingerprint :
    ItemFingerprint<ItemPagerNasheedsBinding, AudioNasheedAdapterModel> {

    override fun isRelativeItem(item: Item) = item is AudioNasheedAdapterModel

    override fun getLayoutId() = R.layout.item_pager_nasheeds

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemPagerNasheedsBinding, AudioNasheedAdapterModel> {
        val binding = ItemPagerNasheedsBinding.inflate(layoutInflater, parent, false)
        return AudioBookVerticalViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<AudioNasheedAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: AudioNasheedAdapterModel,
            newItem: AudioNasheedAdapterModel,
        ) = oldItem.id() == newItem.id()

        override fun areContentsTheSame(
            oldItem: AudioNasheedAdapterModel,
            newItem: AudioNasheedAdapterModel,
        ) = oldItem == newItem
    }
}


class AudioBookVerticalViewHolder(
    binding: ItemPagerNasheedsBinding,
) : BaseViewHolder<ItemPagerNasheedsBinding, AudioNasheedAdapterModel>(binding) {

    override fun onBind(item: AudioNasheedAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        root.startSlideInBottomtAnim()
        poster.context.showImage(item.audioNasheeds.nasheedPoster.url, poster)
        title.text = item.audioNasheeds.title
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnClickListener {
            item.listener.nasheedItemOnClick(item.audioNasheeds.id)
            showSuccessSnackBar("Played Audio is successfully")
        }
        moreBtn.setOnDownEffectClickListener { item.listener.nasheedMoreBtnOnClick(item.audioNasheeds.id) }
    }

    private companion object {
        const val BACKGROUND_IMAGE_BLUR_SIZE = 25f
    }
}

