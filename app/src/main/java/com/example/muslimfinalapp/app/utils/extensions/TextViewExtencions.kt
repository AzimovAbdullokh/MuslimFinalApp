package com.example.muslimfinalapp.app.utils.extensions

import android.text.TextUtils
import android.widget.TextView

fun TextView.makeTicker() {
    ellipsize = TextUtils.TruncateAt.MARQUEE
    isSelected = true
    isSingleLine = true
    marqueeRepeatLimit = -1
}