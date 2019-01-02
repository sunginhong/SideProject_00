package com.example.sunginhong.sideproject_00

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sunginhong.sideproject_00.Model_User.Main_User_Url
import kotlinx.android.synthetic.main.item_raw_page2_item.view.*

class Main_RecyclerViewAdapter_Page2(val context: Context, val userList:ArrayList<Main_User_Url>): RecyclerView.Adapter<Main_RecyclerViewAdapter_Page2.ViewHolder>() {
    var c = context;
//    val arrayMainUserList= arrayListOf<ArrayList<Main_User_min>>()
    var mGroupList = ArrayList<ArrayList<String>>()
    var mChildList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_RecyclerViewAdapter_Page2.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_raw_page2_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Main_RecyclerViewAdapter_Page2.ViewHolder, position: Int) {
        holder.lst_layout.id = position
        holder.title.text = userList[position].title
        holder.subTitle.text = userList[position].subTitle
        Glide.with(c)
            .load(userList[position].imgThumb_Url)
            .into(holder.imgThumb)

        val ctx = context ?: return
        holder.recycle.layoutManager = LinearLayoutManager(ctx, LinearLayout.HORIZONTAL, false)
        holder.recycle.setHasFixedSize(true)
        holder.recycle.adapter = Main_RecyclerViewAdapter_Page2_Item(ctx, userList[position].arrayList)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var lst_layout: ConstraintLayout
        var title: TextView
        var subTitle: TextView
        var imgThumb: ImageView
        var recycle:RecyclerView
        var view = itemView

        init {
            lst_layout = itemView.mainList_raw_p2_lst_layout
            title = itemView.mainList_raw_p2_textTitle
            subTitle = itemView.mainList_raw_p2_textSubTitle
            imgThumb = itemView.mainList_raw_p2_imageThumb
            recycle = itemView.mainList_raw_p2_recyclerView
        }
    }

}