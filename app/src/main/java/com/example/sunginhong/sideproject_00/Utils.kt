package com.example.sunginhong.sideproject_00

import android.content.res.Resources

internal object Utils {
    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().getDisplayMetrics().density) as Int
    }

    fun pxToDp(px: Int): Int {
        return (px / Resources.getSystem().getDisplayMetrics().density) as Int
    }

}