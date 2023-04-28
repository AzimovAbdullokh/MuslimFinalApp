package com.example.muslimfinalapp.app.utils.extensions

import android.app.ActivityManager
import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.muslimfinalapp.R
import com.example.ui_core.extensions.toDp
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

const val KEY_APP_MODE = "KEY_APP_MODE"
const val RESULT_LOAD_IMAGE = 1
const val APP_DATABASE_NAME = "application_database"
const val CONNECT_TIMEOUT_SECONDS = 30L
const val SETTING_THEME_KEY = "theme"
const val SETTING_LANGUAGE_KEY = "language"
const val SETTING_LANGUAGE_AUTO_KEY = "auto"
const val SETTING_LANGUAGE_ENGLISH_KEY = "en"
const val CURRENT_STUDENT_EDITOR_SAVE_KEY = "CURRENT_EDITOR_STUDENT_SAVE_KEY"
const val CURRENT_STUDENT_SAVE_KEY = "CURRENT_STUDENT_SAVE_KEY"
const val IS_FILTER_SAVE_KEY = "IS_FILTER_SAVE_KEY"
const val IS_FILTER_EDITOR_SAVE_KEY = "IS_FILTER_EDITOR_SAVE_KEY"
const val REQUEST_CODE = 42
const val SETTINGS_NAME = "settings"
const val PERMISSION_CODE = 42042
const val READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE"

private fun shimmerDrawable(): ShimmerDrawable {
    val shimmer =
        Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
            .setDuration(1800) // how long the shimmering animation takes to do one full sweep
            .setBaseAlpha(0.7f) //the alpha of the underlying children
            .setHighlightAlpha(0.6f) // the shimmer alpha amount
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .setAutoStart(true)
            .build()

    // This is the placeholder for the imageView
    return ShimmerDrawable().apply {
        setShimmer(shimmer)
    }
}

@Suppress("DEPRECATION")
fun Context.isServiceRunning(serviceClassName: String): Boolean {
    val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager

    return activityManager?.getRunningServices(Integer.MAX_VALUE)
        ?.any { it.service.className == serviceClassName } ?: false
}


fun Context.showImage(uri: String?, imageView: ImageView) {
    Glide.with(this).setDefaultRequestOptions(RequestOptions())
        .load(uri)
        .placeholder(shimmerDrawable())
        .into(imageView)

}

fun Context.showRoundedImage(
    roundedSize: Int = 8.toDp,
    imageUrl: String,
    imageView: ImageView,
    @DrawableRes placeHolder: Int = com.example.ui_core.R.drawable.image_placeholder
) {
    val requestOptions = RequestOptions()
        .transforms(CenterCrop(), RoundedCorners(roundedSize))
        .timeout(3000)
        .placeholder(shimmerDrawable())
    Glide.with(this)
        .load(imageUrl)
        .apply(requestOptions)
        .into(imageView)
}