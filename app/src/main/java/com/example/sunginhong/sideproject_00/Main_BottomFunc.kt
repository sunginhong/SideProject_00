package com.example.sunginhong.sideproject_00

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.main_bottom_actionbar.view.*


class Main_BottomFunc : RelativeLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        Log.d("ssssss", "ssssssss"+bottomMenu_btn_alarm)
    }
}