package com.example.compose_sample_screen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.ui.core.setContent

class ComposeSampleFragment : Fragment() {


    private lateinit var viewModel: ComposeSampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val fragmentView = inflater.inflate(androidx.appcompat.R.layout.abc_action_bar_title_item,
            container,
            false)

        (fragmentView as ViewGroup).setContent {
//            Text("Jetpack Compose")
        }
        return fragmentView
    }

    @Composable
    fun JetKiteButton(

    ) {

    }
//        Button(
////            modifier = modifier.fillMaxWidth(),
//            onClick = onClick,
//            colors = ButtonDefaults.buttonColors(
//                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
//                contentColor = MaterialTheme.colorScheme.onSecondary
//            ),
//            shape = RectangleShape,
//            enabled = enabled,
//        )
}

@Preview
@Composable
fun SimpleComposablePreview() {

}