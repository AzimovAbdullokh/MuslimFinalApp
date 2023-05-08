package com.example.utils_core.extensions

import android.view.View
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.utils_core.R
import com.example.utils_core.snap.OnSnapPositionChangeListener
import com.example.utils_core.snap.SnapOnScrollListener

fun RecyclerView.attachSnapHelperWithListener(
    snapHelper: SnapHelper,
    behavior: SnapOnScrollListener.Behavior = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL,
    onSnapPositionChangeListener: OnSnapPositionChangeListener
) {
    snapHelper.attachToRecyclerView(this)
    val snapOnScrollListener =
        SnapOnScrollListener(snapHelper, onSnapPositionChangeListener, behavior)
    addOnScrollListener(snapOnScrollListener)
}

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}

fun RecyclerView.setupLayoutManager(
    currentItem: (Int) -> Int,
    @LayoutRes itemId: Int,
    @LayoutRes secondItemId: Int
) {
    if (layoutManager !is GridLayoutManager) return
    val gridLayoutManager = layoutManager as? GridLayoutManager
    gridLayoutManager?.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(viewType: Int) =
            when (currentItem(viewType)) {
                itemId -> 1
                secondItemId -> 1
                else -> (layoutManager as GridLayoutManager).spanCount
            }
    }
}

fun View.startSlideInLeftAnim() {
//    this.startAnimation(
    AnimationUtils.loadAnimation(
        this.context,
        R.anim.slide_in_left_anim
    )

}