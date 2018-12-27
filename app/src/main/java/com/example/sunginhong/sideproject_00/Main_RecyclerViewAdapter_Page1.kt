package com.example.sunginhong.sideproject_00

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_raw_page1.view.*


class Main_RecyclerViewAdapter_Page1(val context: Context, val userList:ArrayList<Main_User>):RecyclerView.Adapter<Main_RecyclerViewAdapter_Page1.ViewHolder>() {
    var c = context;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_RecyclerViewAdapter_Page1.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_raw_page1, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Main_RecyclerViewAdapter_Page1.ViewHolder, position: Int) {
        holder.lst_layout.id = position
        holder.title.text = userList[position].title
        holder.subTitle.text = userList[position].subTitle
        Glide.with(c)
            .load(userList[position].imgThumb_Url)
            .into(holder.imgThumb)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var lst_layout: ConstraintLayout
        var title: TextView
        var subTitle: TextView
        var imgThumb: ImageView
        var view = itemView

        init {
            lst_layout = itemView.mainList_raw_p1_lst_layout
            title = itemView.mainList_raw_p1_textTitle
            subTitle = itemView.mainList_raw_p1_textSubTitle
            imgThumb = itemView.mainList_raw_p1_imageThumb

            view.setOnClickListener {

            }
        }
    }
}

