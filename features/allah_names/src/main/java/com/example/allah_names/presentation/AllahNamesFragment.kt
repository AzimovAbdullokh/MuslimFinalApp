package com.example.allah_names.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.allah_names.databinding.FragmentAllahNamesBinding
import com.example.common_api.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllahNamesFragment :
    BaseFragment<FragmentAllahNamesBinding, AllahNamesViewModel>(FragmentAllahNamesBinding::inflate) {

    override val viewModel: AllahNamesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}