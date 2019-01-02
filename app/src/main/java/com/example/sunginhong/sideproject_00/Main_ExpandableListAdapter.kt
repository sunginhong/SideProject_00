package com.example.sunginhong.sideproject_00

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*


class Main_ExpandableListAdapter(val context: Context, private val data: MutableList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var lstHeaderArray = ArrayList<View>()
    var expand_child_llArray = ArrayList<LinearLayout>()
//    var expand_child_ll: LinearLayout? = null

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        var view: View? = null
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_exp_list_header, parent, false)
        val context = parent.context
        val dp = context.resources.displayMetrics.density
        val subItemPaddingLeft = (18 * dp).toInt()
        val subItemPaddingTopAndBottom = (5 * dp).toInt()

        when (type) {
            HEADER -> {
                val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.item_exp_list_header, parent, false)
                lstHeaderArray.add(view)
                return ViewHolder(view)
            }
            CHILD -> {
                val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.item_exp_list_child, parent, false)
                return object : RecyclerView.ViewHolder(view) {
                }
            }
        }
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        when (item.type) {
            HEADER -> {
                val itemController = holder as ViewHolder
                itemController.refferalItem = item
                itemController.header_title.text = item.text
                item.visibleChildren = null
//                item.visibleChildren = ArrayList()
//
//                val pos = data.indexOf(item)
//                val timer = Timer()
//                timer.schedule(timerTask {
//                    var count = 2
//                    while (data.size > pos + 1 && data[pos + 1].type == CHILD) {
//                        item.visibleChildren!!.add(data.removeAt(pos + 1))
//                        count++
//                    }
//                    notifyItemRangeRemoved(pos + 1, count)
//                }, 100)

                itemController.btn_expand_toggle.setBackgroundColor(Color.parseColor("#ffffff"))


                itemController.btn_expand_toggle.setOnClickListener {
                    if (item.visibleChildren == null) {
                        item.visibleChildren = ArrayList()
                        var count = 0
                        val pos = data.indexOf(item)
                        while (data.size > pos + 1 && data[pos + 1].type == CHILD) {
                            item.visibleChildren!!.add(data.removeAt(pos + 1))
                            count++
                        }
                        notifyItemRangeRemoved(pos + 1, count)
                        itemController.btn_expand_toggle.setBackgroundColor(Color.parseColor("#ffffff"))
                    } else {
                        val pos = data.indexOf(item)
                        var index = pos + 1
                        for (i in item.visibleChildren!!) {
                            data.add(index, i)
                            index++
                        }
                        notifyItemRangeInserted(pos + 1, index - pos - 1)
                        itemController.btn_expand_toggle.setBackgroundColor(Color.parseColor("#000000"))
                        item.visibleChildren = null
                    }
                }
            }
            CHILD -> {
                var expand_child_ll = holder.itemView.findViewById(R.id.expand_child_ll) as LinearLayout
                expand_child_llArray.add(expand_child_ll)
//                Utils_Animation.LayoutHeightAnim(expand_child_ll, 0, 0)
                val itemTextView = holder.itemView.findViewById(R.id.expand_child_title) as TextView
                itemTextView.text = data[position].text
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var header_title: TextView
        var btn_expand_toggle: View
        var refferalItem: Item? = null
        var view = itemView

        init {
            header_title = itemView.findViewById(R.id.expand_header_title) as TextView
            btn_expand_toggle = itemView.findViewById<View>(R.id.btn_expand_toggle) as View
        }
    }

    class Item {
        var type: Int = 0
        var text: String = ""
        var visibleChildren: MutableList<Item>? = null

        constructor() {}

        constructor(type: Int, text: String) {
            this.type = type
            this.text = text
        }
    }

    companion object {
        val HEADER = 0
        val CHILD = 1
    }
}