package com.example.sunginhong.sideproject_00

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.main_fragment_page1.*

class Main_Fragment_Page1 : Fragment(){

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.main_fragment_page1, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init (){
        val ctx = context ?: return
        val mAdapter = Main_ViewPagerAdapter_Page1(ctx, MainUserList)
        vp.setAdapter(mAdapter)
        vp.setClipToPadding(false)
        vp.setPageMargin(0)
        vp.setOffscreenPageLimit(MainUserList.size)

        recyclerView_page1.layoutManager = LinearLayoutManager(ctx, LinearLayout.VERTICAL, false)
        recyclerView_page1.setHasFixedSize(true)
        recyclerView_page1.adapter = Main_RecyclerViewAdapter_Page1(ctx, MainUserList)
    }
}