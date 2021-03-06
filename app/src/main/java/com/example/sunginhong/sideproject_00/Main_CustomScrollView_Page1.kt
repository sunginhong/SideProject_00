package com.example.sunginhong.sideproject_00

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ScrollView
import kotlinx.android.synthetic.main.main_fragment_page1.view.*




class Main_CustomScrollView_Page1 : ScrollView {

    companion object {
//        var mainSet = false
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
        if (event.action == 2){
            checkIfScrollStart()
        }

        return super.onInterceptTouchEvent(event)
    }

    override fun stopNestedScroll() {
        super.stopNestedScroll()
        //SCROLL STOP
//        ListLineView_LibraryList.path_animator(400, true)
    }

    override fun onStopNestedScroll(target: View?) {
        super.onStopNestedScroll(target)
        //SCROLL STOP
    }

    override fun onScrollChanged(scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
        super.onScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY)
        //SCROLL MOVE
        val lib_distanceY = -(ListLineView_LibraryList.dragStart_point_y - scrollY)
//        ListLineView_LibraryList.functionRedraw(MainActivity.screenWidth/2-(MainActivity.screenWidth-(ListLineView_LibraryList.frag1_lineview.width).toFloat()), lib_distanceY/2)
    }

    fun checkIfScrollStart(){
        //SCROLL START
        val oldScrollY = main_scrollview_page1.scrollY
//        ListLineView_LibraryList.dragStart_point_y = oldScrollY.toFloat()
    }

    private fun mainSet(){

    }

}
