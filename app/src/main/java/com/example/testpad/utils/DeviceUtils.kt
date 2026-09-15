package com.example.testpad.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class DeviceUtils {

    companion object {
        /**
         * 获取屏幕宽度（像素）
         */
        fun getScreenWidth(context: Context): Int {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val metrics = DisplayMetrics()
            wm.defaultDisplay.getRealMetrics(metrics)
            return metrics.widthPixels
        }
    }
}