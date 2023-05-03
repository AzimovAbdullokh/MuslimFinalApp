package com.example.alarms.presentation.search_audio_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.alarms.databinding.FragmentSearchAudioBinding
import com.example.common_api.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchAudioFragment :
    BaseFragment<FragmentSearchAudioBinding, SearchAudioViewModel>(FragmentSearchAudioBinding::inflate) {

    override val viewModel: SearchAudioViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}