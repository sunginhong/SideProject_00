package com.example.sunginhong.sideproject_00

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunginhong.sideproject_00.Model_User_Json.MainUserList_Url
import kotlinx.android.synthetic.main.main_fragment_page2.*

class Main_Fragment_Page2 : Fragment() {

    companion object {
        var frag2_rv_Array = arrayOfNulls<ConstraintLayout>(0)
        var frag2_rv_Array_Ypos = arrayOfNulls<Float>(0)
    }

    fun newInstance(): Main_Fragment_Page2 {
        val args = Bundle()

        val frag = Main_Fragment_Page2()
        frag.arguments = args

        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.main_fragment_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init (){
        val ctx = context ?: return
        frag2_rv_Array = arrayOfNulls<ConstraintLayout>(MainUserList_Url.size)
        frag2_rv_Array_Ypos = arrayOfNulls<Float>(MainUserList_Url.size)
        val linearLayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
        recyclerView_page2.setHasFixedSize(true)
        linearLayoutManager.isAutoMeasureEnabled = true
        recyclerView_page2.isNestedScrollingEnabled = false
        recyclerView_page2.adapter = Main_RecyclerViewAdapter_Page2(ctx, MainUserList_Url)
        recyclerView_page2.setHasFixedSize(true)
        recyclerView_page2.layoutManager = linearLayoutManager
        ViewCompat.setNestedScrollingEnabled(recyclerView_page2, false)

    }
}