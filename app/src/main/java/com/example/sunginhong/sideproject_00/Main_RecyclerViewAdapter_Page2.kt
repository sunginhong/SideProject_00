package com.example.sunginhong.sideproject_00

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sunginhong.sideproject_00.Main_Fragment_Page2.Companion.frag2_rv_Array
import com.example.sunginhong.sideproject_00.Main_Fragment_Page2.Companion.frag2_rv_Array_Ypos
import com.example.sunginhong.sideproject_00.Model_User.Main_User_Url
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_raw_page2_item.view.*
import java.util.*
import kotlin.concurrent.timerTask


class Main_RecyclerViewAdapter_Page2(val context: Context, val userList:ArrayList<Main_User_Url>): RecyclerView.Adapter<Main_RecyclerViewAdapter_Page2.ViewHolder>() {
    var c = context;
//    val arrayMainUserList= arrayListOf<ArrayList<Main_User_min>>()
    var mGroupList = ArrayList<ArrayList<String>>()
    var mChildList = ArrayList<String>()


    companion object {
        var scrollCardHeight = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_RecyclerViewAdapter_Page2.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_raw_page2_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Main_RecyclerViewAdapter_Page2.ViewHolder, position: Int) {
        val ctx = context ?: return

        holder.lst_layout.id = position
        holder.title.text = userList[position].title
        holder.subTitle.text = userList[position].subTitle

        Picasso.get()
            .load(userList[position].imgThumb_Url)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
            .into(holder.imgThumb)

        val linearLayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
        linearLayoutManager.isAutoMeasureEnabled = true
        holder.recycle.adapter = Main_RecyclerViewAdapter_Page2_Item(ctx, userList[position].arrayList)
        holder.recycle.setLayoutManager(linearLayoutManager)

        holder.lst_layout.id = position
        frag2_rv_Array[position] = holder.lst_layout

        val timer = Timer()
        timer.schedule(timerTask {
            scrollCardHeight = holder.lst_layout.height/2
            frag2_rv_Array_Ypos[position] = holder.lst_layout.y
            if (holder.lst_layout.y > MainActivity.screenHeight){
                holder.lst_layout.y = frag2_rv_Array_Ypos[position]!! + scrollCardHeight
            }
        }, 10)

        super.onViewRecycled(holder)
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