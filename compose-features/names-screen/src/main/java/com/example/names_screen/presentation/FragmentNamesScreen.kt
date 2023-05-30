package com.example.names_screen.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.names_screen.presentation.names_screen.NamesScreen
import com.example.names_screen.presentation.ui.theme.ComposeMuslimAppMaterial3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentNameScreen : Fragment() {

    @SuppressLint("UnrememberedMutableState")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = ComposeView(requireContext()).apply {
        setContent {
            ComposeMuslimAppMaterial3Theme {
                NamesScreen()
            }
        }
    }
}

// Example Показ
@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    ComposeMuslimAppMaterial3Theme {
        NamesScreen()
    }
}