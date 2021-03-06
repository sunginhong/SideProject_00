package com.example.sunginhong.sideproject_00

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.sunginhong.sideproject_00.Model_User_Json.MainUserList
import com.example.sunginhong.sideproject_00.Model_User_Json.MainUserList_Min00
import kotlinx.android.synthetic.main.main_fragment_page1.*




class Main_Fragment_Page1 : Fragment(){

    companion object {
        var PAGE_ITEM_COUNT: Int = 0
        var frag1_vpImage_Array = arrayOfNulls<ImageView>(0)
    }

    fun newInstance(): Main_Fragment_Page1 {
        val args = Bundle()

        val frag = Main_Fragment_Page1()
        frag.arguments = args

        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.main_fragment_page1, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init (){
        val ctx = context ?: return

        val linearLayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
        linearLayoutManager.isAutoMeasureEnabled = true
        recyclerView_page1.isNestedScrollingEnabled = false
        recyclerView_page1.adapter = Main_RecyclerViewAdapter_Page1(ctx, MainUserList)
        recyclerView_page1.layoutManager = linearLayoutManager
        recyclerView_page1.setHasFixedSize(true)
        ViewCompat.setNestedScrollingEnabled(recyclerView_page1, false)
        PAGE_ITEM_COUNT = MainUserList.size

        frag1_vpImage_Array = arrayOfNulls<ImageView>(MainUserList_Min00.size)
        vp.adapter = Main_ViewPagerAdapter_Page1(ctx, MainUserList_Min00)
        vp.clipToPadding = false
        vp.pageMargin = 0
        vp.offscreenPageLimit = MainUserList_Min00.size
        val MainVp_PagerInteraction = Main_CustomVp_frag0_Interaction(vp, ctx)

        tab_layout.setupWithViewPager(vp, true)
    }
}