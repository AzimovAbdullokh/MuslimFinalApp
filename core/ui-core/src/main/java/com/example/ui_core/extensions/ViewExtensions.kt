package com.example.ui_core.extensions

import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.view.ViewTreeObserver
import android.view.WindowInsets
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import com.example.ui_core.R


fun View.measureAndGetWidth(): Int {
    measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    return measuredWidth
}



fun View.setPaddingsZero() {
    this.setPadding(0, 0, 0, 0)
}

fun View.setBackgroundColorToTransperent(context: Context) {
    setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
}

fun View.setMargin(insets: WindowInsets, defaultMargin: Int) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
        setMargins(0, insets.systemWindowInsetTop + defaultMargin, 0, 0)
    }
}

fun View.setMarginForRecyclerView() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        insets.toWindowInsets()?.let { v.setMargin(it, 0) }
        insets
    }
}

fun ViewGroup.checkingIntersectionView(vararg views: View, callbacks: (Boolean) -> Unit) {
    views.forEach {
        if (it.parent != this) {
            callbacks.invoke(false)
            return
        }
    }
    viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {

        override fun onPreDraw(): Boolean {
            viewTreeObserver.removeOnPreDrawListener(this)

            for (i in 0 until views.size - 1) {
                val firstViewRect = Rect()
                for (j in (i + 1) until views.size) {
                    val secondViewRect = Rect()
                    views[i].getDrawingRect(firstViewRect)
                    views[j].getDrawingRect(secondViewRect)
                    offsetDescendantRectToMyCoords(views[i], firstViewRect)
                    offsetDescendantRectToMyCoords(views[j], secondViewRect)
                    if (Rect.intersects(firstViewRect, secondViewRect)) {
                        callbacks.invoke(true)
                        return false
                    }
                }
            }
            callbacks.invoke(false)
            return false
        }
    })
}

fun View.setMargins(left: Int, top: Int, right: Int, bottom: Int) {
    if (this.layoutParams is MarginLayoutParams) {
        val p = this.layoutParams as MarginLayoutParams
        p.setMargins(left, top, right, bottom)
        this.requestLayout()
    }
}

fun View.setPointBackground(isTop: Boolean) {
    if (isTop) {
        this.setBackgroundResource(R.drawable.circle_big_background)
    } else {
        this.setBackgroundResource(R.drawable.circle_small_background)
    }
}