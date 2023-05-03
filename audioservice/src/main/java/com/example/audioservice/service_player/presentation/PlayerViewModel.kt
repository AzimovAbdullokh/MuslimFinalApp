package com.example.audioservice.service_player.presentation

import androidx.lifecycle.viewModelScope
import com.example.audioservice.service_player.domain.models.NasheedsFeatureModel
import com.example.audioservice.service_player.domain.repository.FeatureAudioRepository
import com.example.audioservice.service_player.presentation.models.AudioNasheedsUi
import com.example.audioservice.service_player.service_player.PlaybackManager
import com.example.common_api.DispatchersProvider
import com.example.common_api.Mapper
import com.example.common_api.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val featureAudioRepository: FeatureAudioRepository,
    private val dispatchersProvider: DispatchersProvider,
    private val playbackManager: PlaybackManager,
    private val featureAudioNasheedDomainToUiMapper: Mapper<NasheedsFeatureModel, AudioNasheedsUi>,
) : BaseViewModel() {

    val audioNasheedIdFlow = MutableStateFlow<Pair<String, Boolean>?>(null)

    private val _playMediaFlow = createMutableSharedFlowAsSingleLiveEvent<AudioNasheedsUi>()
    val playMediaFlow: SharedFlow<AudioNasheedsUi> get() = _playMediaFlow.asSharedFlow()

    private val _playbackSpeedFlow = MutableStateFlow(0f)
    val playbackSpeedFlow: StateFlow<Float> get() = _playbackSpeedFlow.asStateFlow()


    val audioNasheedFlow = audioNasheedIdFlow.flatMapLatest {
        val audioBook = if (it != null) featureAudioRepository
            .fetchAudioNasheedFromCacheObservable(it.first)
            .map(featureAudioNasheedDomainToUiMapper::map)
        else flow { emit(AudioNasheedsUi.unknown()) }
        if (it != null && it.second) _playMediaFlow.tryEmit(audioBook.first())
        if (_playbackSpeedFlow.value != playbackManager.playbackSpeed) {
            _playbackSpeedFlow.value = playbackManager.playbackSpeed
        }
        audioBook
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun refreshIfNecessary(audioBookId: String) {
        if (audioNasheedFlow.value == null) {
            audioNasheedIdFlow.tryEmit(Pair(audioBookId, false))
        }
    }

    fun play(audioBookId: String) {
        audioNasheedIdFlow.tryEmit(Pair(audioBookId, true))
    }

    fun prepare(audioBookId: String) {
        audioNasheedIdFlow.tryEmit(Pair(audioBookId, false))
    }

    fun updateAudioBookIsPlayingState(
        isPlaying: Boolean,
        audioBookId: String? = audioNasheedIdFlow.value?.first) {}

    fun changePlaybackSpeed(playbackSpeed: Float) {
        playbackManager.playbackSpeed = playbackSpeed
        _playbackSpeedFlow.tryEmit(playbackSpeed)
    }
}