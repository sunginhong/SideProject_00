package com.example.sunginhong.sideproject_00

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import com.example.sunginhong.sideproject_00.Main_CustomVp_frag0_Interaction.Companion.frag0_vp_scrollBool
import com.example.sunginhong.sideproject_00.Main_CustomVp_frag0_Interaction.Companion.frag0_vp_startXPosition


class Main_CustomVp_frag0(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    var enabled: Boolean? = false

    init {
        this.enabled = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.enabled!!) {
            super.onTouchEvent(event)
        } else false

    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                frag0_vp_scrollBool = true
                frag0_vp_startXPosition = event.x
            }
        }
        return if (this.enabled!!) {
            super.onInterceptTouchEvent(event)
        } else false

    }

    fun setPagingEnabled(enabled: Boolean) {
        this.enabled = enabled
    }
}