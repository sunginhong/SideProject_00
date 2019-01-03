package com.example.sunginhong.sideproject_00

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.test_detail_activity.*


class DetailActivity_Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_detail_activity)

        val intent = intent
        val testId = intent.getStringExtra("testId")
        testDetail_textView.text = testId
    }
}