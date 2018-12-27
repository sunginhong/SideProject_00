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
        fun newInstance(): Main_Fragment_Page1 {
            var fragmentHome = Main_Fragment_Page1()
            var args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }
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
        val mAdapter = Main_ViewPagerAdapter(ctx, MainUserList)
        vp.setAdapter(mAdapter)
        vp.setClipToPadding(false)
        vp.setPageMargin(0)
        vp.setOffscreenPageLimit(MainUserList.size)

        recyclerView.layoutManager = LinearLayoutManager(ctx, LinearLayout.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = Main_RecyclerViewAdapter(ctx, MainUserList)
    }
}