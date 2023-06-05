package com.example.names_screen.presentation.names_screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.names_screen.R
import com.example.names_screen.data.AllahNames
import com.example.names_screen.presentation.extencion.orFalse
import com.example.names_screen.presentation.extencion.verticalGradientBackground
import com.example.names_screen.presentation.ui.animation.DraggableCard
import com.example.names_screen.presentation.ui.animation.MultiStateAnimationCircleFilledCanvas
import com.example.names_screen.presentation.ui.purple
import com.example.names_screen.presentation.ui.tertiary

@SuppressLint("FlowOperatorInvokedInComposition")
@Preview
@Composable
fun NamesScreen() {

    val viewModel: NamesScreenViewModel = viewModel()
    val persons = viewModel.albumLiveData

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val cardHeight = screenHeight - 200.dp

    Surface(modifier = Modifier.fillMaxSize()) {
        val boxModifier = Modifier

        Box(modifier = boxModifier.verticalGradientBackground(listOf(Color.White,
            tertiary.copy(alpha = 0.2f)))) {
            val listEmpty = remember { mutableStateOf(false) }
            DatingLoader(modifier = boxModifier)


            persons.value?.forEachIndexed { index, album ->

                DraggableCard(item = album,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(cardHeight)
                        .padding(
                            top = 16.dp + (index + 2).dp,
                            bottom = 16.dp,
                            start = 16.dp,
                            end = 16.dp,
                        ),
                    onSwiped = { _, swipedAlbum ->
                        if (persons.value?.isNotEmpty().orFalse()) {
                            persons.value?.remove(swipedAlbum)
                            if (persons.value?.isEmpty().orFalse()) {
                                listEmpty.value = true
                            }
                        }
                    }) {
                    CardContent(album = album)
                }
            }
        }
    }
}


@Composable
fun CardContent(album: AllahNames) {
    Column {
        Image(
            painter = painterResource(album.imageId),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            Text(
                text = album.artist,
                style = typography.h6,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Start)
        }
        Text(
            text = "Names by Muslim App",
            style = typography.subtitle2,
            modifier = Modifier.padding(bottom = 4.dp, start = 16.dp, end = 16.dp))
    }
}

@Composable
fun DatingLoader(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center, modifier = modifier
        .fillMaxSize()
        .clip(CircleShape)) {
        MultiStateAnimationCircleFilledCanvas(purple, 400f)

        Image(
            painter = painterResource(id = R.drawable.arrahman),
            modifier = modifier
                .size(50.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}