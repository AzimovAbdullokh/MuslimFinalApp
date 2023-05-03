package com.example.alarms.presentation.view_pager.masalah

import androidx.fragment.app.viewModels
import com.example.alarms.databinding.FragmentMasalahBinding
import com.example.common_api.base.BaseFragment

class MasalahFragmentForViewPager :
    BaseFragment<FragmentMasalahBinding, MasalahViewModel>(FragmentMasalahBinding::inflate) {

    override val viewModel: MasalahViewModel by viewModels()


}