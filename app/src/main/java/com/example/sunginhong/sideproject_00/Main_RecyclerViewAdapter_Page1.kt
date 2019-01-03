package com.example.sunginhong.sideproject_00


import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sunginhong.sideproject_00.MainActivity.Companion.URL_THUMB_IMG
import kotlinx.android.synthetic.main.item_raw_page1.view.*
import java.util.*

class Main_RecyclerViewAdapter_Page1(internal var context: Context, internal var arrayList: ArrayList<Array<String>>) :
    RecyclerView.Adapter<Main_RecyclerViewAdapter_Page1.ViewHolder>(), View.OnClickListener {
    var c = context;
    private var view: ViewHolder? = null
    private var testTitleArray = arrayOfNulls<String>(100)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_RecyclerViewAdapter_Page1.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_raw_page1, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Main_RecyclerViewAdapter_Page1.ViewHolder, position: Int) {
        view = holder
        val detail = arrayList[position]

        holder.lst_layout.id = position
        holder.title.text = detail[0]
        holder.subTitle.text = detail[1]
        Glide.with(c)
            .load(URL_THUMB_IMG + detail[2])
            .into(holder.imgThumb)
        holder.lst_layout.setOnClickListener(this)
        testTitleArray[position] = detail[0]
    }

    override fun getItemCount(): Int {
        return arrayList.size
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

    override fun onClick(view: View?) {
        val nextIntent = Intent(context, DetailActivity_Test::class.java)
        val putExtra = nextIntent.putExtra("testId", testTitleArray[view!!.id])
        view!!.context.startActivity(nextIntent)
    }

}




