package com.example.sunginhong.sideproject_00

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList = arrayListOf<Main_User>(
            Main_User("A","hong@naver.com","https://s3.amazonaws.com/appsdeveloperblog/micky.gif"),
            Main_User("B","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("C","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("D","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("E","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("F","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("G","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("H","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("I","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("J","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png"),
            Main_User("K","hong@naver.com","https://cdn.dribbble.com/users/14268/screenshots/5593802/joy-fm_2x.png")
        )

        //레이아웃매니저 설정
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        //어답터 설정
        recyclerView.adapter = Main_RecyclerViewAdapter(context(), userList)
    }

    fun context(): Context {
        return applicationContext
    }
}

