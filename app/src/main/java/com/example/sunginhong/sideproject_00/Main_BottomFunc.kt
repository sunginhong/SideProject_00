package com.example.sunginhong.sideproject_00

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.main_bottom_actionbar.view.*
import java.util.*
import kotlin.concurrent.timerTask

class Main_BottomFunc : RelativeLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val timer = Timer()
        timer.schedule(timerTask {
            bottomBtnSet()
        }, 100)
    }

    private fun bottomBtnSet () {
        // ButtonSetting
        bottomMenu_btn_write.setOnClickListener { Log.d("ssssss", "sssss"+bottomMenu_btn_write) }
        bottomMenu_btn_home.setOnClickListener { Log.d("ssssss", "sssss"+bottomMenu_btn_home) }
        bottomMenu_btn_search.setOnClickListener { Log.d("ssssss", "sssss"+bottomMenu_btn_search) }
        bottomMenu_btn_my.setOnClickListener { Log.d("ssssss", "sssss"+bottomMenu_btn_my) }
        bottomMenu_btn_alarm.setOnClickListener { Log.d("ssssss", "sssss"+bottomMenu_btn_alarm) }
    }
}