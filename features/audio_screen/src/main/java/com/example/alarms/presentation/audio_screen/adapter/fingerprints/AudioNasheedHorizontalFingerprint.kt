package com.example.alarms.presentation.audio_screen.adapter.fingerprints

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.alarms.R
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.alarms.databinding.ItemAudioNasheedBinding
import com.example.alarms.databinding.ItemBigAudioNasheedBinding
import com.example.alarms.presentation.audio_screen.models.adapter_models.AudioNasheedAdapterModel
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showBlurImage
import com.example.utils_core.extensions.showImage


class AudioNasheedHorizontalFingerprint :
    ItemFingerprint<ItemBigAudioNasheedBinding, AudioNasheedAdapterModel> {

    override fun isRelativeItem(item: Item) = item is AudioNasheedAdapterModel

    override fun getLayoutId() = R.layout.item_big_audio_nasheed

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemBigAudioNasheedBinding, AudioNasheedAdapterModel> {
        val binding = ItemBigAudioNasheedBinding.inflate(layoutInflater, parent, false)
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
    binding: ItemBigAudioNasheedBinding,
) : BaseViewHolder<ItemBigAudioNasheedBinding, AudioNasheedAdapterModel>(binding) {

    override fun onBind(item: AudioNasheedAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun createCustomTarget() = object : CustomTarget<Bitmap>() {
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            createPaletteAsync(resource)
        }
        override fun onLoadCleared(placeholder: Drawable?) = Unit }

    private fun setupViews() = with(binding) {
        posterImageView.context.showImage(item.audioNasheeds.nasheedPoster.url, posterImageView)
        Glide.with(itemView.context)
            .asBitmap()
            .load(item.audioNasheeds.nasheedPoster.url)
            .into(createCustomTarget())

        backgroundColor.context.showBlurImage(
            blurSize = BITMAP_SCALE,
            imageUrl = item.audioNasheeds.nasheedPoster.url,
            imageView = backgroundColor,
        )

        title.text = item.audioNasheeds.title
        description.text = "Audio Description is null because server is dont answering leady"
    }

    private fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->
            val color = when {
                palette?.lightVibrantSwatch != null -> palette.lightVibrantSwatch!!.rgb
                palette?.dominantSwatch != null -> palette.dominantSwatch!!.rgb
                palette?.lightMutedSwatch != null -> palette.lightMutedSwatch!!.rgb
                palette?.vibrantSwatch != null -> palette.vibrantSwatch!!.rgb
                palette?.mutedSwatch != null -> palette.mutedSwatch!!.rgb
                palette?.darkVibrantSwatch != null -> palette.darkVibrantSwatch!!.rgb
                else -> itemView.context.getColor(com.example.ui_core.R.color.rating_second_color)
            }
            binding.backgroundColor.setBackgroundColor(color)
        }
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnDownEffectClickListener {
            item.listener.nasheedItemOnClick(item.audioNasheeds.id)
            showSuccessSnackBar("Playyed Description server")
        }
    }

    companion object {
        private const val BITMAP_SCALE = 30f
    }
}



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

