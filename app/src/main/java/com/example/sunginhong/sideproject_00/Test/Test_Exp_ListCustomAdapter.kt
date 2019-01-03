package com.example.sunginhong.sideproject_00.Test

//import android.view.animation.AnimationUtils
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.sunginhong.sideproject_00.R


class Test_Exp_ListCustomAdapter(
    private val context: Context,
    groupLay: Int,
    chlidLay: Int,
    private var DataList: ArrayList<Test_Exp_Prototype_myGroup>
) : BaseExpandableListAdapter() {
    private var groupLayout = 0
    private var chlidLayout = 0

    private var myinf: LayoutInflater? = null
    private var title: String? = null
    private var protoType_rowTitle: TextView? = null

    init {
        this.groupLayout = groupLay
        this.chlidLayout = chlidLay
        this.myinf = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // TODO Auto-generated method stub
        if (convertView == null) {
            convertView = myinf!!.inflate(this.groupLayout, parent, false)
        }
        protoType_rowTitle = convertView!!.findViewById(R.id.protoType_rowTitle)
        protoType_rowTitle!!.setText(DataList[groupPosition].groupName)
        childArraySet = false
        return convertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        // TODO Auto-generated method stub
        if (convertView == null) {
            convertView = myinf!!.inflate(this.chlidLayout, parent, false)
        }
        protoType_rowChild = convertView!!.findViewById(R.id.protoType_rowChild)
        protoType_rowChild.setText(DataList[groupPosition].childExp.get(childPosition))

        return convertView
    }

    override fun hasStableIds(): Boolean {
        // TODO Auto-generated method stub
        return true
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        // TODO Auto-generated method stub
        return true
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        // TODO Auto-generated method stub
        return DataList[groupPosition].childExp.get(childPosition)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        // TODO Auto-generated method stub
        return childPosition.toLong()
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        // TODO Auto-generated method stub
        return DataList[groupPosition].childExp.size
    }

    override fun getGroup(groupPosition: Int): Test_Exp_Prototype_myGroup {
        // TODO Auto-generated method stub
        return DataList[groupPosition]
    }

    override fun getGroupCount(): Int {
        // TODO Auto-generated method stub
        return DataList.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        // TODO Auto-generated method stub
        return groupPosition.toLong()
    }

    companion object {
        lateinit var protoType_rowChild: TextView

        var childArraySet = false

    }

}