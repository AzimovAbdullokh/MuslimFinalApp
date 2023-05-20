package com.example.compose_sample_screen

object Deps {
    const val version = "1.3.0-beta02"
    const val compilerVersion = "1.3.0"
    const val activityVersion = "1.6.0-rc02"


    const val ui = "androidx.compose.ui:ui:$version"
    const val uiUtil = "androidx.compose.ui:ui-util:$version"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
    const val foundation = "androidx.compose.foundation:foundation:$version"
    const val material = "androidx.compose.material:material:$version"
    const val material3 = "androidx.compose.material3:material3:1.0.0-beta02"
    const val materialIcons = "androidx.compose.material:material-icons-core:$version"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha03"
    const val liveData = "androidx.compose.runtime:runtime-livedata:$version"
    const val activity = "androidx.activity:activity-compose:$activityVersion"
    const val paging = "androidx.paging:paging-compose:1.0.0-alpha16"

    const val uiTestJunit = "androidx.compose.ui:ui-test-junit4:$version"
    const val uiTestManifeset = "androidx.compose.ui:ui-test-manifest:$version"

    private const val lottieVersion = "5.2.0"
    const val lottie = "com.airbnb.android:lottie-compose:$lottieVersion"

    const val coil = "io.coil-kt:coil-compose:${Utils.coilVersion}"
    const val reorderable = "org.burnoutcrew.composereorderable:reorderable:0.9.2"
    const val swipe = "me.saket.swipe:swipe:1.0.0"

}

object Utils {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:1.4.0"
    const val proguardSnippets =
        "com.github.yongjhih.android-proguards:android-proguards-all:-SNAPSHOT"

    const val threeTen = "org.threeten:threetenbp:1.6.1"

    const val coilVersion = "2.2.1"
    const val coil = "io.coil-kt:coil:$coilVersion"
    const val store = "com.dropbox.mobile.store:store4:4.0.5"

    // const val fetch = "androidx.tonyodev.fetch2:xfetch2:3.1.6"
    // const val fetchOkhttp = "androidx.tonyodev.fetch2okhttp:xfetch2okhttp:3.1.6"
    const val fetch = "com.github.alashow:Fetch:3.1.62"
    const val fetchOkhttp = "com.github.alashow:xfetch2okhttp:3.1.62"

    const val exoPlayer = "com.google.android.exoplayer:exoplayer-core:2.15.1"
    const val exoPlayerOkhttp = "com.google.android.exoplayer:extension-okhttp:2.15.0"
    const val exoPlayerFlac = "com.github.alashow.ExoPlayer-Extensions:extension-flac:v2.15.1"

    const val qonversion = "io.qonversion.android.sdk:sdk:3.3.1"
}