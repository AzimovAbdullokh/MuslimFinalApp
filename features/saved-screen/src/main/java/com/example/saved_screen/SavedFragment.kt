package com.example.saved_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.saved_screen.databinding.FragmentSavedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedFragment :
    BaseFragment<FragmentSavedBinding, SavedViewModel>(FragmentSavedBinding::inflate) {

    override val viewModel: SavedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}