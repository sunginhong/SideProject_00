package com.example.sunginhong.sideproject_00

import android.view.View
import android.view.animation.*

internal object Utils_Animation {

    fun TransAnim(view:View, startX:Float, endX:Float, startY:Float, endY:Float, duration:Int ) {
        val anim = TranslateAnimation(
            startX, endX,
            startY, endY
        )
        anim.fillAfter = true
        anim.interpolator = DecelerateInterpolator(1.5.toFloat())
        anim.duration = duration.toLong()
        view.startAnimation(anim)
    }

    fun AlphaAnim(view:View, startAlpha:Float, endAlpha:Float, duration:Int ) {
        val anim = AlphaAnimation(startAlpha, endAlpha)
        anim.fillAfter = true
        anim.interpolator = DecelerateInterpolator(1.5.toFloat())
        anim.duration = duration.toLong()
        view.startAnimation(anim)
    }

    fun SclaeAnim(view:View, startScaleX:Float, endScaleX:Float, startScaleY:Float,endScaleY:Float, originX:Float, originY:Float, duration:Int) {
        val anim = ScaleAnimation(startScaleX, endScaleX, startScaleY, endScaleY, Animation.RELATIVE_TO_SELF, originX, Animation.RELATIVE_TO_SELF, originY)
        anim.fillAfter = true
        anim.interpolator = DecelerateInterpolator(1.5.toFloat())
        anim.duration = duration.toLong()
        view.startAnimation(anim)
    }

    fun ResizeAnim(view:View, targetHeight:Int, duration:Long){
        val resizeAnimation = Resize_HeightAnimation(view, targetHeight)
        resizeAnimation.fillAfter = true
        resizeAnimation.interpolator = DecelerateInterpolator(1.5.toFloat())
        resizeAnimation.duration = duration
        view.startAnimation(resizeAnimation)
    }

}