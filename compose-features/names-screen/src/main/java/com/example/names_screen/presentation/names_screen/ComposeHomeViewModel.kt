package com.example.names_screen.presentation.names_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.names_screen.data.Album
import com.example.names_screen.data.AlbumsDataProvider

//@HiltViewModel
class ComposeHomeViewModel(
) : ViewModel() {

    private val _albumLiveData = MutableLiveData<MutableList<Album>>()
    val albumLiveData: LiveData<MutableList<Album>> = _albumLiveData

    init {
        getAlbums()
    }

    private fun getAlbums() {
        _albumLiveData.value = AlbumsDataProvider.albums.take(8).toMutableList()
    }



//    private val _namesFlow = MutableStateFlow(NamesFeatureUi.unknown())
//    val namesFlow: StateFlow<NamesFeatureUi> get() = _namesFlow.asStateFlow()
//
//    private fun <T : Any> createMutableSharedFlowAsSingleLiveEvent(): MutableSharedFlow<T> =
//        MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST)
//
//    init {
//        getAlbumsFlow()
//    }
//
//    private fun getAlbumsFlow() {
////        namesFlow.flatMapLatest {
////            namesFeatureRepository.fetchAllNames().take(5)
////        }
//    }
}