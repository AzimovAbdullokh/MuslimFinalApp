package com.example.tasbih_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.tasbih_screen.databinding.FragmentTasbihBinding
import com.example.utils_core.extensions.setOnDownEffectClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasbihFragment :
    BaseFragment<FragmentTasbihBinding, TasbihFragmentViewModel>(FragmentTasbihBinding::inflate) {

    override val viewModel: TasbihFragmentViewModel by viewModels()

    var tasbihCountS = 0
    var allSalavatS = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickers()
    }

    private fun setupClickers() = with(binding()) {
        upButton.setOnDownEffectClickListener { viewModel.navigateBack() }

        tasbihBtn.setOnDownEffectClickListener {
            tasbihCountS++
            tasbihCount.text = tasbihCountS.toString()
            subhanallah()
            alhamdulillah()
            allahuAkbar()
        }
    }

    private fun subhanallah() = with(binding()) {
        if (tasbihCountS == 1) {
            salavat.text = "Subhanallah"
        }
    }

    private fun alhamdulillah() = with(binding()) {
        if (tasbihCountS == 34) {
            salavat.text = "Alhamdullilah"
        }
    }

    private fun allahuAkbar() = with(binding()) {
        if (tasbihCountS == 67) {
            salavat.text = "Allahu Akbar"

        } else if (tasbihCountS == 100) {
            tasbihCountS = 0
            subhanallah()

            allSalavatS ++
            allSalavat.text = allSalavatS.toString()

        }
    }

}