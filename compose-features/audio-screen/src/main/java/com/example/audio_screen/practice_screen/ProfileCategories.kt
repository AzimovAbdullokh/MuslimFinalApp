package com.example.audio_screen.practice_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
internal fun ProfileCategories(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    navigateSettingScreen: () -> Unit,
    navigateLoginOutScreen: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.onSecondary,
        elevation = 8.dp,
        modifier = modifier
            .padding(
                all = 16.dp,
            )
            .fillMaxWidth()
            .height(350.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    all = 16.dp
                )
        ) {
            Categories(
                title = "stringResource(id = R.string.my_account)",
                description = "stringResource(id = R.string.make_changes_to_your_account)",
                iconId = com.example.ui_core.R.drawable.play_icon,
                onClick = {

                }
            )
            Categories(
                title = stringResource(id = com.example.ui_core.R.string.settings),
                description = stringResource(id = com.example.ui_core.R.string.settings),
                iconId = com.example.ui_core.R.drawable.setting_icon,
                onClick = {
                    navigateSettingScreen()
                }
            )
            Categories(
                title = "Face ID / Touch ID",
                description = "Manage your device security",
                iconId = com.example.ui_core.R.drawable.loader_icon,
                onClick = {

                }
            )
            CategoriesSwitch(
                title = stringResource(id = com.example.ui_core.R.string.masalah),
                description = stringResource(id = com.example.ui_core.R.string.main),
                iconId = com.example.ui_core.R.drawable.pause_icon,
                isDarkTheme = isDarkTheme,
                onCheckedChange = onThemeChange
            )
            Categories(
                title = stringResource(id = com.example.ui_core.R.string.login_input_format_error),
                description = stringResource(id = com.google.android.material.R.string.error_a11y_label),
                iconId = com.example.ui_core.R.drawable.arhive_load_fill,
                tint = MaterialTheme.colors.error,
                onClick = {
                    navigateLoginOutScreen()
                }
            )
        }
    }
}