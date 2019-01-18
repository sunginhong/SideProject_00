package com.example.sunginhong.sideproject_00

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Main_Exp_UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal var expItem: ConstraintLayout
    internal var userAvatar: ImageView
    internal var username: TextView

    init {
        expItem = itemView.findViewById(R.id.exp_item_cl)
        userAvatar = itemView.findViewById(R.id.exp_item_imageview_profile)
        username = itemView.findViewById(R.id.exp_item_textview_name)
    }
}