package com.example.sunginhong.sideproject_00

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.view.MotionEvent
import android.view.View

class Main_Vp_interaction(private val vp: ViewPager, context: Context) : ViewPager(context), ViewPager.OnPageChangeListener, ViewPager.PageTransformer,
    View.OnTouchListener {

    companion object {
    }


    private var enabled: Boolean? = false

    init {
        vp.addOnPageChangeListener(this)
        vp.setOnTouchListener(this)
        var pageWidth = vp.width
        vp.currentItem = 0
        this.enabled = true
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> { }
            MotionEvent.ACTION_UP -> {

            }
            MotionEvent.ACTION_MOVE -> {
            }
        }
        return false
    }


    override fun transformPage(page: View, position: Float) {}

    @SuppressLint("MissingSuperCall")
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        MainActivity.currentPageIndex = position
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}