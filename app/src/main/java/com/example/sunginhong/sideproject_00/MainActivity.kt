package com.example.sunginhong.sideproject_00

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import com.example.sunginhong.sideproject_00.Utils_Folder.Utils_Animation
import com.example.sunginhong.sideproject_00.Utils_Folder.getScreenSize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_bottom_actionbar.*
import java.util.*
import kotlin.concurrent.timerTask
import android.util.Pair as UtilPair








class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
    val arrayBtmButton = arrayListOf<ImageButton>()
    var selectBottomIndex = 0

    companion object {
        var currentPageIndex =0
        var screenHeight = 0
        var screenWidth = 0
        var URL_JSON = "http://rstudi0.cafe24.com/json/"
        var URL_THUMB_IMG = "http://rstudi0.cafe24.com/json/img/"
        var URL_LINK = "http://jjangik.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.sunginhong.sideproject_00.R.layout.activity_main)
        val ctx = context() ?: return

        screenHeight = getScreenSize(this).y
        screenWidth = getScreenSize(this).x

        val pagerAdapter = Main_PagerAdapter(supportFragmentManager)
        mainvp.adapter = pagerAdapter
        val MainVp_PagerInteraction = Main_Vp_interaction(mainvp, ctx)

        arrayBtmButton.add(bottomMenu_btn_home)
        arrayBtmButton.add(bottomMenu_btn_search)
        arrayBtmButton.add(bottomMenu_btn_my)
        arrayBtmButton.add(bottomMenu_btn_alarm)
        arrayBtmButton.add(bottomMenu_btn_write)
        bottomButtonSet()

        val timer = Timer()
        timer.schedule(timerTask {  }, 300)
        var ss = Utils_Animation.ValueAnimator(0f, 400f, 1000)
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        var rootView = inflater!!.inflate(com.example.sunginhong.sideproject_00.R.layout.activity_main, container, false)
//        return rootView
//    }


    fun context(): Context {
        return applicationContext
    }

    fun bottomButtonSet() {
        for (i in 0 until arrayBtmButton.size) {
            arrayBtmButton[i].setOnClickListener(View.OnClickListener { view ->
                if (i < 4){  mainvp.currentItem = i }
                if (i == 4){ selectIndex_0(view) }
            })
        }
    }

    fun selectIndex_0(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val options = ActivityOptions.makeSceneTransitionAnimation(this,
                UtilPair.create(view, "bottomMenu_btn_center_anim"))

            val intent = Intent(this, Main_SeacrchView::class.java)
            view.context.startActivity(intent, options.toBundle())
        } else {
            val intent = Intent(view.context, Main_SeacrchView::class.java)
            view.context.startActivity(intent)
        }
    }
}

