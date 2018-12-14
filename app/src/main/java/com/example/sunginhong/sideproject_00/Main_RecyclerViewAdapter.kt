package com.example.sunginhong.sideproject_00

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_raw.view.*


class Main_RecyclerViewAdapter(val context: Context, val userList:ArrayList<Main_User>):RecyclerView.Adapter<Main_RecyclerViewAdapter.ViewHolder>() {
    var c = context;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_raw, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: Main_RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.lst_layout.id = position
        holder.title.text = userList[position].title
        holder.subTitle.text = userList[position].subTitle
        Glide.with(c)
            .load(userList[position].imgThumb_Url)
            .into(holder.imgThumb)
    }

    //아이템의 갯수
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
            lst_layout = itemView.lst_layout
            title = itemView.textTitle
            subTitle = itemView.textSubTitle
            imgThumb = itemView.imageThumb

            view.setOnClickListener {
                Log.d("ssss", "sss"+view.id)
            }
        }

    }
}

