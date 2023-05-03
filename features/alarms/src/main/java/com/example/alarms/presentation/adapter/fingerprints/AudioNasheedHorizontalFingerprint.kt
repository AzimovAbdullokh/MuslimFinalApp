package com.example.alarms.presentation.adapter.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.alarms.R
import com.example.alarms.databinding.ItemAudioNasheedBinding
import com.example.alarms.presentation.models.AudioNasheedAdapterModel
import com.example.alarms.presentation.ui.option_dialog.NasheedOptionDialogFragment
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.ui_core.custom.modal_page.ModalPage
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showBlurImage
import com.example.utils_core.extensions.showImage


class AudioNasheedHorizontalFingerprint :
    ItemFingerprint<ItemAudioNasheedBinding, AudioNasheedAdapterModel> {

    override fun isRelativeItem(item: Item) = item is AudioNasheedAdapterModel

    override fun getLayoutId() = R.layout.item_audio_nasheed

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemAudioNasheedBinding, AudioNasheedAdapterModel> {
        val binding = ItemAudioNasheedBinding.inflate(layoutInflater, parent, false)
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
    binding: ItemAudioNasheedBinding,
) : BaseViewHolder<ItemAudioNasheedBinding, AudioNasheedAdapterModel>(binding) {

    override fun onBind(item: AudioNasheedAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        poster.context.showImage(item.audioNasheeds.nasheedPoster.url, poster)
//        backgroundColor.context.showBlurImage(
//            blurSize = BACKGROUND_IMAGE_BLUR_SIZE,
//            imageUrl = item.audioNasheeds.nasheedPoster.url,
//            imageView = backgroundColor
//        )
        title.text = item.audioNasheeds.title
        genre.text = "Genre is null"
    }



    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.nasheedItemOnClick(item.audioNasheeds.id)
            showSuccessSnackBar("Playyed")
        }

    }

    private companion object {
        const val BACKGROUND_IMAGE_BLUR_SIZE = 25f
    }
}

