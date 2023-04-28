package com.example.main_screen.presentation.adapter.fingerpints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemNasheedBinding
import com.example.main_screen.presentation.models.adapter_models.AudioNasheedAdapterModel
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showBlurImage
import com.example.utils_core.extensions.showImage


class AudioNasheedHorizontalFingerprint :
    ItemFingerprint<ItemNasheedBinding, AudioNasheedAdapterModel> {

    override fun isRelativeItem(item: Item) = item is AudioNasheedAdapterModel

    override fun getLayoutId() = R.layout.item_nasheed

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemNasheedBinding, AudioNasheedAdapterModel> {
        val binding = ItemNasheedBinding.inflate(layoutInflater, parent, false)
        return AudioBookHorizontalViewHolder(binding)
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


class AudioBookHorizontalViewHolder(
    binding: ItemNasheedBinding,
) : BaseViewHolder<ItemNasheedBinding, AudioNasheedAdapterModel>(binding) {

    override fun onBind(item: AudioNasheedAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        posterImageView.context.showImage(item.audioNasheeds.nasheedPoster.url, posterImageView)
        backgroundColor.context.showBlurImage(
            blurSize = BACKGROUND_IMAGE_BLUR_SIZE,
            imageUrl = item.audioNasheeds.nasheedPoster.url,
            imageView = backgroundColor
        )
        title.text = item.audioNasheeds.title
        description.text = item.audioNasheeds.createdAt.toString()
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.nasheedItemOnClick(item.audioNasheeds.id)
        }
    }

    private companion object {
        const val BACKGROUND_IMAGE_BLUR_SIZE = 25f
    }
}

