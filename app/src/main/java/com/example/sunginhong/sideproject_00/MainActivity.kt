package com.example.sunginhong.sideproject_00

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screenHeight = getScreenSize(this).y
        screenWidth = getScreenSize(this).x

        arrayBtmButton.add(bottomMenu_btn_write)
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
                    fragmentReplace(Main_Fragment_Page0())
                }
                if (i == 1 && selectBottomIndex != 1){
                    selectBottomIndex = 1
                    fragmentReplace(Main_Fragment_Page1())
                }
                if (i == 2 && selectBottomIndex != 2){
                    selectBottomIndex = 2
                    fragmentReplace(Main_Fragment_Page2())
                }
                if (i == 3 && selectBottomIndex != 3){
                    selectBottomIndex = 3
                    fragmentReplace(Main_Fragment_Page3())
                }
                if (i == 4 && selectBottomIndex != 4){
                    selectBottomIndex = 4
                    fragmentReplace(Main_Fragment_Page4())
                }
            }
        }
    }

    fun fragmentReplace(fragment: Fragment){
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.main_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}

