package com.example.utils_core.extensions

import android.util.TypedValue
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.SearchView
import com.example.utils_core.R

fun SearchView.setupTextSize() {
    val searchText = this.findViewById<View>(
        this.context.resources.getIdentifier(
            "android:id/search_src_text",
            null,
            null
        )
    ) as AutoCompleteTextView
//    searchText.setTextColor(Color.WHITE)
    searchText.setTextSize(
        TypedValue.COMPLEX_UNIT_PX,
        resources.getDimensionPixelSize(R.dimen.text_small).toFloat()
    )
}