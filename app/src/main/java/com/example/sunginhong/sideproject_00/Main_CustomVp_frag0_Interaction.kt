package com.example.sunginhong.sideproject_00

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.view.MotionEvent
import android.view.View
import com.example.sunginhong.sideproject_00.Main_Fragment_Page1.Companion.mainVp_imageThumb_Array

class Main_CustomVp_frag0_Interaction(private val vp: ViewPager, context: Context) : ViewPager(context), ViewPager.OnPageChangeListener, ViewPager.PageTransformer,
    View.OnTouchListener {

    companion object {
        var frag0_vp_scrollBool: Boolean? = false
        var frag0_vp_startXPosition = 0f
    }

    private var endXPosition = 0f
    private var positionNEXT: Int = 0
    private var selected_index = 0
    private var selected_index_before = 0
    private var currentIdx = 0;
    private var CAL_IMG = 1.5f
    private var CAL_PAGING = 1.0 / Main_Fragment_Page1.PAGE_ITEM_COUNT

    private var vpDirection: String? = null
    private var currentItemIdx = 0
    private var currentItem_scroll_Idx = 0
    private var positionMAX = Main_Fragment_Page1.PAGE_ITEM_COUNT - 1
    private var itemLength = 2
    private var mLastOffset: Float = 0.toFloat()
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
            MotionEvent.ACTION_DOWN -> {
                frag0_vp_scrollBool = true
                frag0_vp_startXPosition = event.x
            }
            MotionEvent.ACTION_UP -> frag0_vp_scrollBool = false
            MotionEvent.ACTION_MOVE -> {
                endXPosition = event.x
                if (frag0_vp_startXPosition > endXPosition && frag0_vp_startXPosition - endXPosition > 10) {
                    vpDirection = "RIGHT"
                } else if (frag0_vp_startXPosition < endXPosition && endXPosition - frag0_vp_startXPosition > 10) {
                    vpDirection = "LEFT"
                }
            }
        }
        return false
    }


    override fun transformPage(page: View, position: Float) {}

    @SuppressLint("MissingSuperCall")
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        currentIdx = position
        val pageScrollX = 0f

        positionNEXT = 0
        if (position < positionMAX) {
            positionNEXT = position + 1
        }
        currentItemIdx = position

        if (positionOffset >= 0.0 && positionOffset < 0.5) {
            if (currentItem_scroll_Idx > position) {
                currentItem_scroll_Idx = currentItem_scroll_Idx - 1
            }
        }
        if (positionOffset > 0.5 && positionOffset < 1.0) {
            if (currentItem_scroll_Idx < itemLength) {
                currentItem_scroll_Idx = position + 1
            }
        }

        for (i in 0 until mainVp_imageThumb_Array.size) {
            if (i == currentIdx) {
                mainVp_imageThumb_Array[i]!!.translationX = 0 + positionOffsetPixels/2f
            }
            if (i == currentIdx+1){
                mainVp_imageThumb_Array[i]!!.translationX = -vp.getWidth()/2f + positionOffsetPixels/2f
            }

        }
            mLastOffset = positionOffset
    }

    override fun onPageSelected(position: Int) {
        val pageWidth = vp.width
        selected_index = position
        selected_index_before = position

        if (positionNEXT == selected_index) {
        }
        if (positionNEXT != selected_index) {
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}