package com.example.sunginhong.sideproject_00

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.main_fragment_page3.*

class Main_Fragment_Page3 : Fragment() {

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.main_fragment_page3, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val ctx = context ?: return

        recyclerView_page3.layoutManager = LinearLayoutManager(ctx, LinearLayout.VERTICAL, false)
        recyclerView_page3.setHasFixedSize(true)
        recyclerView_page3.adapter = Main_ExpandableListAdapter(ctx, Main_ExUserList)
    }
}