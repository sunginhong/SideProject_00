package com.example.sunginhong.sideproject_00

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.main_fragment_page3.*
import java.util.*







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
//        recyclerView_page3.adapter = Main_ExpandableListAdapter(ctx, Main_ExUserList)
        val data = ArrayList<Main_ExpandableListAdapter.Item>()

        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.HEADER, "A"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "0-1"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "0-2"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "0-3"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "0-4"))

        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.HEADER, "B"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "1-1"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "1-2"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "1-3"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "1-4"))

        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.HEADER, "C"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "2-1"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "2-2"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "2-3"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "2-4"))

        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.HEADER, "D"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "3-1"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "3-2"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "3-3"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "3-4"))

        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.HEADER, "E"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "4-1"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "4-2"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "4-3"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "4-4"))

        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.HEADER, "F"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "5-1"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "5-2"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "5-3"))
        data.add(Main_ExpandableListAdapter.Item(Main_ExpandableListAdapter.CHILD, "5-4"))

        recyclerView_page3.adapter = Main_ExpandableListAdapter(ctx, data)
    }


}