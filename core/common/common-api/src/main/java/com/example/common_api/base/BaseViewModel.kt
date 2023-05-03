package com.example.common_api.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_api.IdResourceString
import com.example.common_api.communication.NavigationCommunication
import com.example.common_api.event.Event
import com.example.common_api.navigation.NavCommand
import com.example.common_api.navigation.NavigationCommand
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel : ViewModel() {

    private var navigationCommunication = NavigationCommunication.Base()

    private var _navCommand = createMutableSharedFlowAsSingleLiveEvent<NavCommand>()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    private val _isErrorMessageIdFlow = createMutableSharedFlowAsSingleLiveEvent<IdResourceString>()
    val isErrorMessageIdFlow: SharedFlow<IdResourceString> get() = _isErrorMessageIdFlow.asSharedFlow()

    private var dispatchers = com.example.common_api.dispatchers.Dispatchers.Base()

    fun <T : Any> createMutableSharedFlowAsSingleLiveEvent(): MutableSharedFlow<T> =
        MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST)


    fun navigate(navCommand: NavCommand) = _navCommand.tryEmit(navCommand)

    fun navigateBack() =
        launchInBackground { navigationCommunication.put(Event(value = NavigationCommand.Back)) }

    fun emitToErrorMessageFlow(messageId: IdResourceString) =
        _isErrorMessageIdFlow.tryEmit(messageId)



    fun <T> launchInBackground(backgroundCall: suspend () -> T) =
        dispatchers.launchInBackground(viewModelScope) { backgroundCall() }


}