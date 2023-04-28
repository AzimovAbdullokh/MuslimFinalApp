package com.example.main_screen.presentation.models.adapter_models

import com.example.common_api.base.adapter.Item
import com.example.main_screen.presentation.listeners.NasheedItemOnClickListener
import com.example.main_screen.presentation.models.AudioNasheedsUi

data class AudioNasheedAdapterModel(
    val audioNasheeds: AudioNasheedsUi,
    val listener: NasheedItemOnClickListener,
) : Item {
    fun id() = audioNasheeds.id + audioNasheeds.title
}
