package com.example.sunginhong.sideproject_00

import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation


class Resize_HeightAnimation(var view: View, val targetHeight: Int) :
    Animation() {
    val startHeight = view.height

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        val newHeight = ( startHeight + (targetHeight - startHeight) * interpolatedTime).toInt()
        view.getLayoutParams().height = newHeight
        view.requestLayout()
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
    }

    override fun willChangeBounds(): Boolean {
        return true
    }
}