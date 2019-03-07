package com.example.sunginhong.sideproject_00

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.view.animation.DecelerateInterpolator


class Main_SeacrchView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(com.example.sunginhong.sideproject_00.R.layout.activity_searchview)
        val bounds = ChangeBounds()
        bounds.duration = 300
        bounds.interpolator = DecelerateInterpolator(1.5f)
        window.sharedElementEnterTransition = bounds
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onBackPressed() {
        finishAfterTransition()
    }

    override fun onPause() {
        super.onPause()
    }

}