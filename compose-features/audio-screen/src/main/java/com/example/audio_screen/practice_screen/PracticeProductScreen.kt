package com.example.audio_screen.practice_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ComposablePreview() {
    MaterialTheme {
        ProductScreen()
    }
}

@Composable
fun ProductScreen() {

    LazyColumn(content = {
        item { Toolbar() }

    }, modifier = Modifier.fillMaxSize())
}

@Composable
fun RatingRowView() {
    Box(modifier = Modifier
        .background(color = Color.Gray)
        .height(52.dp)
        .fillMaxWidth())
}


@Composable
fun ImageHeader() {
    Box(modifier = Modifier
        .background(Color.Gray)
        .height(300.dp)
        .fillMaxWidth())
}


@Composable
fun Toolbar() {
    Row(modifier = Modifier
        .height(44.dp)
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.background)) {
        Text("Back", Modifier.size(200.dp))
        Text("Menu")
    }
}