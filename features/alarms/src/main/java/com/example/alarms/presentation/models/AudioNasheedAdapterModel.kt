package com.example.alarms.presentation.models

import com.example.alarms.presentation.listeners.NasheedItemOnClickListener
import com.example.common_api.base.adapter.Item

data class AudioNasheedAdapterModel(
    val audioNasheeds: AudioNasheedsUi,
    val listener: NasheedItemOnClickListener,
) : Item {
    fun id() = audioNasheeds.id + audioNasheeds.title
}
