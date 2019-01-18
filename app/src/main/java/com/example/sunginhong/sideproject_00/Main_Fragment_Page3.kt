package com.example.sunginhong.sideproject_00

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunginhong.sideproject_00.Model_User_Json.Exp_UsersData
import kotlinx.android.synthetic.main.main_fragment_page3.*




@Suppress("UNREACHABLE_CODE")
class Main_Fragment_Page3 : Fragment() {

    companion object {
    }

    fun newInstance(): Main_Fragment_Page3 {
        val args = Bundle()

        val frag = Main_Fragment_Page3()
        frag.arguments = args

        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.main_fragment_page3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val ctx = context ?: return

        val linearLayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
        recyclerView_page3.setHasFixedSize(true)

        recyclerView_page3.layoutManager = linearLayoutManager
        val adapter = Main_Exp_UserListAdapter(ctx)
        recyclerView_page3.adapter = adapter
        recyclerView_page3.itemAnimator = DefaultItemAnimator()

        val usersData = Exp_UsersData()
        val usersList = usersData.usersList
        val userTypeList = usersData.userTypeList

        adapter.setUserListAndType(usersList, userTypeList)

    }


}

