package com.example.sunginhong.sideproject_00

import android.content.Context
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.main_fragment_page1.view.*


class Main_CustomNestedScrollingView_Page1 : NestedScrollView {
    private var mState = RecyclerView.SCROLL_STATE_IDLE

    private var mScrollListener: NestedScrollViewScrollStateListener? = null

    interface NestedScrollViewScrollStateListener {
        fun onNestedScrollViewStateChanged(state: Int)
    }

    fun setScrollListener(scrollListener: NestedScrollViewScrollStateListener) {
        this.mScrollListener = scrollListener
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun stopNestedScroll() {

        super.stopNestedScroll()
        dispatchScrollState(RecyclerView.SCROLL_STATE_IDLE)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        if (event.action == 0){
            checkIfScrollStart()
        }

        return super.onInterceptTouchEvent(event)
    }

    override fun onStartNestedScroll(child: View, target: View, nestedScrollAxes: Int): Boolean {

        dispatchScrollState(RecyclerView.SCROLL_STATE_DRAGGING)
        return super.onStartNestedScroll(child, target, nestedScrollAxes)
    }


    override fun startNestedScroll(axes: Int): Boolean {
        val superScroll = super.startNestedScroll(axes)
        dispatchScrollState(RecyclerView.SCROLL_STATE_DRAGGING)
        return superScroll
    }

    private fun dispatchScrollState(state: Int) {
        if (state == 1) {
            /// scrollStart
        }
        if (state == 0) {
            /// scrollEnd
            ListLineView_LibraryList.path_animator(300, true)
        }
        if (mScrollListener != null && mState != state) {
            mScrollListener!!.onNestedScrollViewStateChanged(state)
            mState = state
        }
    }

    override fun onScrollChanged(scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
        super.onScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY)
        //SCROLL MOVE
        val lib_distanceY = -(ListLineView_LibraryList.dragStart_point_y - scrollY)
        ListLineView_LibraryList.functionRedraw(MainActivity.screenWidth/2-(MainActivity.screenWidth-(ListLineView_LibraryList.frag1_lineview.width).toFloat()), lib_distanceY/2)
    }

    fun checkIfScrollStart(){
        //SCROLL START
        val oldScrollY = main_scrollview_page1.scrollY
        ListLineView_LibraryList.dragStart_point_y = oldScrollY.toFloat()
    }

}