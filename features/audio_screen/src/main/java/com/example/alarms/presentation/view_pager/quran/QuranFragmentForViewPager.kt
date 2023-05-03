package com.example.alarms.presentation.view_pager.quran

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.alarms.databinding.FragmentQuranBinding
import com.example.common_api.base.BaseFragment

class QuranFragmentForViewPager :
    BaseFragment<FragmentQuranBinding, QuranViewModel>(FragmentQuranBinding::inflate) {

    override val viewModel: QuranViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}