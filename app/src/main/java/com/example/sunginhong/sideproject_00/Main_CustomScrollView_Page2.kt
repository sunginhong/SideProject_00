package com.example.sunginhong.sideproject_00

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ScrollView

class Main_CustomScrollView_Page2 : ScrollView {

    companion object {
    }
    
    private var ScrollViewListener: ScrollView? = null
    private var currentlyTouching = false
    private var currentlyScrolling = false

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun fling(velocityY: Int) {
        super.fling(velocityY)
    }
    override fun onStartNestedScroll(child: View?, target: View?, nestedScrollAxes: Int): Boolean {
        return super.onStartNestedScroll(child, target, nestedScrollAxes)
    }

    override fun onNestedScroll(target: View?, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
    }

    override fun onNestedPreScroll(target: View?, dx: Int, dy: Int, consumed: IntArray?) {
        super.onNestedPreScroll(target, dx, dy, consumed)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        if (event.action == 0){
            checkIfScrollStart()
        }
        return super.onInterceptTouchEvent(event)
    }

    override fun onStopNestedScroll(target: View?) {
        super.onStopNestedScroll(target)
        //SCROLL STOP
    }

    override fun onScrollChanged(scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
        super.onScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY)
        //SCROLL MOVE
//        main_scrollview_page2.scrollTo(0, scrollY)
    }

    fun checkIfScrollStart(){
        //SCROLL START
    }


}
