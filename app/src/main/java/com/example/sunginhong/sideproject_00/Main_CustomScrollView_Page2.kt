package com.example.sunginhong.sideproject_00

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ScrollView
import com.example.sunginhong.sideproject_00.Main_RecyclerViewAdapter_Page2.Companion.scrollCardHeight
import com.example.sunginhong.sideproject_00.Utils_Folder.Utils_Animation


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class Main_CustomScrollView_Page2 : ScrollView {

    companion object {
    }

    private var ScrollViewListener: ScrollView? = null
    private var currentlyTouching = false
    private var currentlyScrolling = false
    private var scrolledDistance = 0
    private var visibile = false
    private var frag2Set = false

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
        scrolledDistance = scrollY;
        cardAnim()

        //SCROLL MOVE
//        main_scrollview_page2.scrollTo(0, scrollY)
    }

    fun checkIfScrollStart(){
        //SCROLL START
    }

    fun cardAnim () {
        for (i in 0 until Main_Fragment_Page2.frag2_rv_Array.size) {
            if (scrolledDistance - Main_Fragment_Page2.frag2_rv_Array[i]!!.y < 0 && scrolledDistance - Main_Fragment_Page2.frag2_rv_Array[i]!!.y < -(MainActivity.screenHeight)) {
                if (Main_Fragment_Page2.frag2_rv_Array[i]!!.y === Main_Fragment_Page2.frag2_rv_Array_Ypos[i]!! + scrollCardHeight.toFloat()) {
                    Main_Fragment_Page2.frag2_rv_Array[i]!!.y = Main_Fragment_Page2.frag2_rv_Array_Ypos[i]!!
                    Utils_Animation.TransAnim(Main_Fragment_Page2.frag2_rv_Array[i]!!, 0f, 0f, Main_Fragment_Page2.frag2_rv_Array_Ypos[i]!! + scrollCardHeight, 0f, 600)
                }
            }
            if (scrolledDistance - Main_Fragment_Page2.frag2_rv_Array[i]!!.y < 0 && scrolledDistance - Main_Fragment_Page2.frag2_rv_Array[i]!!.y < -MainActivity.screenHeight) {
                if (Main_Fragment_Page2.frag2_rv_Array[i]!!.y === Main_Fragment_Page2.frag2_rv_Array_Ypos[i]!!) {
                    Utils_Animation.TransAnim(Main_Fragment_Page2.frag2_rv_Array[i]!!, 0f, 0f, 0f, Main_Fragment_Page2.frag2_rv_Array_Ypos[i]!! + scrollCardHeight, 0)
                    Main_Fragment_Page2.frag2_rv_Array[i]!!.y = Main_Fragment_Page2.frag2_rv_Array_Ypos[i]!! + scrollCardHeight.toFloat()
                }
            }
        }

    }


}
