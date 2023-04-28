package com.example.alarms.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.alarms.databinding.FragmentNasheedsBinding
import com.example.common_api.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasheedsFragment :
    BaseFragment<FragmentNasheedsBinding, NasheedsFragmentViewModel>(FragmentNasheedsBinding::inflate) {

    override val viewModel: NasheedsFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}