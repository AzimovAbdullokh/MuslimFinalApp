package com.example.alarms.presentation.audio_screen.adapter.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.alarms.R
import com.example.alarms.databinding.ItemAudioNasheedBinding
import com.example.alarms.presentation.audio_screen.models.adapter_models.AudioNasheedAdapterModel
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage
import com.example.utils_core.extensions.startSlideInLeftAnim

class AudioNasheedHorizontalFingerprintSecond :
    ItemFingerprint<ItemAudioNasheedBinding, AudioNasheedAdapterModel> {

    override fun isRelativeItem(item: Item) = item is AudioNasheedAdapterModel

    override fun getLayoutId() = R.layout.item_audio_nasheed

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemAudioNasheedBinding, AudioNasheedAdapterModel> {
        val binding = ItemAudioNasheedBinding.inflate(layoutInflater, parent, false)
        return AudioBookHorizontalSecondViewHolder(binding)
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


class AudioBookHorizontalSecondViewHolder(
    binding: ItemAudioNasheedBinding,
) : BaseViewHolder<ItemAudioNasheedBinding, AudioNasheedAdapterModel>(binding) {

    override fun onBind(item: AudioNasheedAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        poster.context.showImage(item.audioNasheeds.nasheedPoster.url, poster)
        title.text = item.audioNasheeds.title
        genre.text = "Audio genre is null"
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.nasheedItemOnClick(item.audioNasheeds.id)
            showSuccessSnackBar("Playyed Description server")
        }
    }
}

