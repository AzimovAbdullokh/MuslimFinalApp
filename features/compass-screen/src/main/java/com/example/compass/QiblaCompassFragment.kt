package com.example.compass

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.compass.databinding.FragmentQiblaCompassBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QiblaCompassFragment :
    BaseFragment<FragmentQiblaCompassBinding, QiblaCompassViewModel>(FragmentQiblaCompassBinding::inflate) {

    override val viewModel: QiblaCompassViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}