package com.example.namaz_times_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.namaz_times_screen.databinding.FragmentNamazTimesBinding

class NamazTimesFragment :
    BaseFragment<FragmentNamazTimesBinding, NamazTimesViewModel>(FragmentNamazTimesBinding::inflate) {

    override val viewModel: NamazTimesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}