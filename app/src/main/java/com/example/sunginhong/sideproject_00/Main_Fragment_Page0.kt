package com.example.sunginhong.sideproject_00

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Main_Fragment_Page0 : Fragment() {

    companion object {
    }

    fun newInstance(): Main_Fragment_Page0 {
        val args = Bundle()

        val frag = Main_Fragment_Page0()
        frag.arguments = args

        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.main_fragment_page0, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}