package com.example.sunginhong.sideproject_00

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_bottom_actionbar.*
import java.util.*
import kotlin.concurrent.timerTask


class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
    val arrayBtmButton = arrayListOf<ImageButton>()
    var selectBottomIndex = 0


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
        var ss = Utils_Animation.ValueAnimator(0f, 400f, 1000)
        timer.schedule(timerTask {  }, 300)
    }

    fun context(): Context {
        return applicationContext
    }

    fun bottomButtonSet() {
        val fitstFragment = Main_Fragment_Page1()
        val secondFragment = Main_Fragment_Page2()
        val thirdFragment = Main_Fragment_Page3()
        val fourFragment = Main_Fragment_Page4()

        for (i in 0 until arrayBtmButton.size) {
            arrayBtmButton[i].setOnClickListener {
                main_scrollview.scrollTo(0,0)
                if (i == 1 && selectBottomIndex != 1){
                    selectBottomIndex = 1
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.main_fragment, fitstFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
                if (i == 2 && selectBottomIndex != 2){
                    selectBottomIndex = 2
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.main_fragment, secondFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
                if (i == 3 && selectBottomIndex != 3){
                    selectBottomIndex = 3
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.main_fragment, thirdFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
                if (i == 4 && selectBottomIndex != 4){
                    selectBottomIndex = 4
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.main_fragment, fourFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }
    }




}

