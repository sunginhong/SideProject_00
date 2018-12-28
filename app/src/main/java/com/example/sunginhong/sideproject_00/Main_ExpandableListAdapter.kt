package com.example.sunginhong.sideproject_00

import android.content.ClipData.Item
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_exp_list_header.view.*


class Main_ExpandableListAdapter(val context: Context, val userList:ArrayList<Main_ExUser>):RecyclerView.Adapter<Main_ExpandableListAdapter.ViewHolder>() {

    companion object {
        val HEADER = 0
        val CHILD = 1
    }

    var c = context;
    private val data: List<Item>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_ExpandableListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_exp_list_header, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Main_ExpandableListAdapter.ViewHolder, position: Int) {
        holder.expand_header_title.text = userList[position].title
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var expand_header_title: TextView
        var btn_expand_toggle: ImageView
        var view = itemView

        init {
            expand_header_title = itemView.expand_header_title
            btn_expand_toggle = itemView.btn_expand_toggle
        }
    }
}