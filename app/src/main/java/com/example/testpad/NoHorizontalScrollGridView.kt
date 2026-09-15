package com.example.testpad

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.leanback.widget.VerticalGridView


/**
 * 禁用水平滚动的 VerticalGridView，防止触摸板左右滑动时内容移出屏幕。
 */
class NoHorizontalScrollGridView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : VerticalGridView(context, attrs, defStyleAttr) {

    private var startX = 0f
    private var startY: Float = 0f

    override fun canScrollHorizontally(direction: Int): Boolean = false

    override fun fling(velocityX: Int, velocityY: Int): Boolean {
        // 只保留垂直方向的 fling
        return super.fling(0, velocityY)
    }

}
