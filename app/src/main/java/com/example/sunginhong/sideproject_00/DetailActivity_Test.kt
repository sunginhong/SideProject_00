package com.example.sunginhong.sideproject_00

import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.test_detail_activity.*




class DetailActivity_Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_detail_activity)

        val intent = intent
        val testId = intent.getStringExtra("testId")
        testDetail_textView.text = testId
        Log.d("ssssss", "ssss"+testId)
    }

    override fun onResume() {
        this.overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out)
        super.onResume()
    }

    override fun onBackPressed() {
        ActivityCompat.finishAfterTransition(this)
        this.overridePendingTransition(R.anim.activity_slide_in2, R.anim.activity_slide_out2)
    }
}