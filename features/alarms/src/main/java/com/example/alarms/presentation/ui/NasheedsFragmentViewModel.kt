package com.example.alarms.presentation.ui

import com.example.common_api.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NasheedsFragmentViewModel @Inject constructor(
) : BaseViewModel() {

    fun goCompassScreen() = debounce {

    }
}