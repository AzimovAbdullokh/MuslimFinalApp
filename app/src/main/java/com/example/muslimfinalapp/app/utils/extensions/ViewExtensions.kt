package com.example.muslimfinalapp.app.utils.extensions

import android.graphics.Rect
import android.view.View
import android.view.animation.AnimationUtils
import com.example.muslimfinalapp.R
import com.thekhaeng.pushdownanim.PushDownAnim

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.downEffect(): View {
    PushDownAnim.setPushDownAnimTo(this)
    return this
}


fun View.setPointBackground(isTop: Boolean) {
    if (isTop) {
        this.setBackgroundResource(com.example.ui_core.R.drawable.circle_big_background)
    } else {
        this.setBackgroundResource(com.example.ui_core.R.drawable.circle_small_background)
    }
}

fun View.setOnDownEffectClickListener(onClickListener: View.OnClickListener): View {
    PushDownAnim.setPushDownAnimTo(this).setOnClickListener(onClickListener)
    return this
}

fun View.startSlideInLeftAnim() {
    this.startAnimation(
        AnimationUtils.loadAnimation(
            this.context,
            com.example.ui_core.R.anim.slide_in_left_anim
        )
    )
}

fun View.pointInView(pointX: Float, pointY: Float): Boolean {
    val outRect = Rect()
    val location = IntArray(2)

    getDrawingRect(outRect)
    getLocationOnScreen(location)
    outRect.offset(location[0], location[1])

    return outRect.contains(pointX.toInt(), pointY.toInt())
}