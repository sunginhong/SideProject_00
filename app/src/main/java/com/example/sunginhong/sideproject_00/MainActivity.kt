package com.example.sunginhong.sideproject_00

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import com.example.sunginhong.sideproject_00.Utils_Folder.Utils_Animation
import com.example.sunginhong.sideproject_00.Utils_Folder.getScreenSize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_bottom_actionbar.*
import java.util.*
import kotlin.concurrent.timerTask


class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
    val arrayBtmButton = arrayListOf<ImageButton>()
    var selectBottomIndex = 1


    companion object {
        var screenHeight = 0
        var screenWidth = 0
        var URL_JSON = "http://rstudi0.cafe24.com/json/"
        var URL_THUMB_IMG = "http://rstudi0.cafe24.com/json/img/"
        var URL_LINK = "http://jjangik.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screenHeight = getScreenSize(this).y
        screenWidth = getScreenSize(this).x

        val pagerAdapter = Main_PagerAdapter(supportFragmentManager)
        mainvp.adapter = pagerAdapter
//        mainvp.setCurrentItem(0)

//        arrayBtmButton.add(bottomMenu_btn_write)
        arrayBtmButton.add(bottomMenu_btn_home)
        arrayBtmButton.add(bottomMenu_btn_search)
        arrayBtmButton.add(bottomMenu_btn_my)
        arrayBtmButton.add(bottomMenu_btn_alarm)
        bottomButtonSet()

        val timer = Timer()
        timer.schedule(timerTask {  }, 300)
        var ss = Utils_Animation.ValueAnimator(0f, 400f, 1000)
    }

    fun context(): Context {
        return applicationContext
    }

    fun bottomButtonSet() {
        for (i in 0 until arrayBtmButton.size) {
            arrayBtmButton[i].setOnClickListener {
                if (i == 0 && selectBottomIndex != 0){
                    selectBottomIndex = 0
                }
                if (i == 1 && selectBottomIndex != 1){
                    selectBottomIndex = 1
                }
                if (i == 2 && selectBottomIndex != 2){
                    selectBottomIndex = 2
                }
                if (i == 3 && selectBottomIndex != 3){
                    selectBottomIndex = 3
                }
                if (i == 4 && selectBottomIndex != 4){
                    selectBottomIndex = 4
                }
                mainvp.setCurrentItem(selectBottomIndex)
            }
        }
    }
}

