package com.example.sunginhong.sideproject_00

import android.content.Context
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {

    companion object {
        var screenHeight = 0
        var screenWidth = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screenHeight = getScreenSize(this).y
        screenWidth = getScreenSize(this).x
        val timer = Timer()

        val RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        RecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        RecyclerView.setHasFixedSize(true)
        RecyclerView.adapter = Main_RecyclerViewAdapter(context(), MainUserList)

        val vp = findViewById<ViewPager>(R.id.vp)
        val mAdapter = Main_ViewPagerAdapter(context(), MainUserList)
        vp.setAdapter(mAdapter)
        vp.setClipToPadding(false)
        vp.setPageMargin(0)
        vp.setOffscreenPageLimit(MainUserList.size)

        var ss = Utils_Animation.ValueAnimator(0f, 400f, 1000)

        timer.schedule(timerTask { }, 300)
    }

    fun context(): Context {
        return applicationContext
    }


}

