package com.example.audioservice.service_player.service_player

import kotlinx.coroutines.flow.SharedFlow

interface PlayerCallback {

    val playerStatusFlow: SharedFlow<PlayerStatus>

    fun play(audioBookId: String)

    fun playLatestListeningAudio()

    fun stop()

}