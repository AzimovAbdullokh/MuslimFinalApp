package com.example.ui_core.custom.snackbar

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.ui_core.R

interface GenericSnackbarIconsProvider {

    fun infoSnackbarIcon(): Drawable?

    fun successSnackbarIcon(): Drawable?

    fun warningSnackbarIcon(): Drawable?

    fun errorSnackbarIcon(): Drawable?

    class Base(private val context: Context) : GenericSnackbarIconsProvider {

        override fun infoSnackbarIcon(): Drawable? =
            ContextCompat.getDrawable(context, R.drawable.info_circle_svgrepo_com)

        override fun successSnackbarIcon(): Drawable? =
            ContextCompat.getDrawable(context, R.drawable.tick_circle_svgrepo_com)

        override fun warningSnackbarIcon(): Drawable? =
            ContextCompat.getDrawable(context, R.drawable.warning_circle_svgrepo_com)

        override fun errorSnackbarIcon(): Drawable? =
            ContextCompat.getDrawable(context, R.drawable.cross_circle_svgrepo_com)
    }
}