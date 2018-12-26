package com.example.sunginhong.sideproject_00

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.main_bottom_actionbar.view.*
import java.util.*
import kotlin.concurrent.timerTask


class Main_BottomFunc : RelativeLayout {
    companion object {
        val arrayBtmButton = arrayListOf<ImageButton>()
        var BottomMenu_item_Contain: LinearLayout? = null

    }
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val timer = Timer()
        timer.schedule(timerTask {
            bottomBtn_init()
        }, 100)
    }

    private fun bottomBtn_init () {
        // ButtonSetting
        BottomMenu_item_Contain = bottomMenu_item_Contain

        arrayBtmButton.add(bottomMenu_btn_write)
        arrayBtmButton.add(bottomMenu_btn_home)
        arrayBtmButton.add(bottomMenu_btn_search)
        arrayBtmButton.add(bottomMenu_btn_my)
        arrayBtmButton.add(bottomMenu_btn_alarm)

        for (i in 0 until arrayBtmButton.size) {
            arrayBtmButton[i].setOnClickListener {
                Log.d("ssssss", ""+i)
            }
        }
    }
}