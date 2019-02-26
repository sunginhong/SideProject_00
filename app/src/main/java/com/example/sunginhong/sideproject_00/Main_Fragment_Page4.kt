package com.example.sunginhong.sideproject_00

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Main_Fragment_Page4 : Fragment() {

    companion object {
        var frag4_rv_Array = arrayOfNulls<ConstraintLayout>(0)
    }

    fun newInstance(): Main_Fragment_Page4 {
        val args = Bundle()

        val frag = Main_Fragment_Page4()
        frag.arguments = args

        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ctx = context ?: return

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(com.example.sunginhong.sideproject_00.R.layout.main_fragment_page4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val ctx = context ?: return

        val linearLayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
//        recyclerView_page4.setHasFixedSize(true)
//        linearLayoutManager.isAutoMeasureEnabled = true
//        recyclerView_page4.isNestedScrollingEnabled = false
//        recyclerView_page4.adapter = Main_RecyclerViewAdapter_Page4(ctx, MainUserFrag4_List_Url)
//        recyclerView_page4.setHasFixedSize(true)
//        recyclerView_page4.layoutManager = linearLayoutManager
//        ViewCompat.setNestedScrollingEnabled(recyclerView_page4, false)
    }

}