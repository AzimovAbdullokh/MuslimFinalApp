package com.example.alarms.presentation.audio_screen.models.adapter_models

import com.example.alarms.presentation.audio_screen.listeners.NasheedItemOnClickListener
import com.example.alarms.presentation.audio_screen.models.AudioNasheedsUi
import com.example.common_api.base.adapter.Item

data class AudioNasheedAdapterModel(
    val audioNasheeds: AudioNasheedsUi,
    val listener: NasheedItemOnClickListener,
) : Item {
    fun id() = audioNasheeds.id + audioNasheeds.title
}
