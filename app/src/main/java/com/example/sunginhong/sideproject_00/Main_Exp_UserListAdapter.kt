package com.example.sunginhong.sideproject_00

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunginhong.sideproject_00.Model_User.Main_Exp_User
import com.example.sunginhong.sideproject_00.Model_User.Main_Exp_ViewType
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class Main_Exp_UserListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    Main_Exp_SectionHeaderViewHolder.HeaderViewHolderCallback, View.OnClickListener {
    private var usersList: List<Main_Exp_User>? = null
    private var userTypeList: List<String>? = null

    private var viewTypes: SparseArray<Main_Exp_ViewType>? = null
    private var headerExpandTracker: SparseIntArray? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        when (viewType) {
            USER_TYPE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.exp_layout_user_list_item, parent, false)
                return Main_Exp_UserViewHolder(view)
            }
            HEADER_TYPE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.exp_layout_user_list_header, parent, false)
                return Main_Exp_SectionHeaderViewHolder(view, this)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.exp_layout_user_list_item, parent, false)
                return Main_Exp_UserViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewType = getItemViewType(position)
        val viewType = viewTypes!!.get(position)
        if (itemViewType == USER_TYPE) {
            bindUserViewHolder(holder, viewType)
        } else {
            bindHeaderViewHolder(holder, position, viewType)
        }
    }

    private fun bindHeaderViewHolder(holder: RecyclerView.ViewHolder, position: Int, viewType: Main_Exp_ViewType) {
        val dataIndex = viewType.dataIndex
        val headerViewHolder = holder as Main_Exp_SectionHeaderViewHolder
        headerViewHolder.sectionTitle.setText(userTypeList!![dataIndex])
        if (isExpanded(position)) {
            headerViewHolder.sectionTitle
//                .setCompoundDrawablesWithIntrinsicBounds(null, null, headerViewHolder.arrowUp, null)
        } else {
            headerViewHolder.sectionTitle
//                .setCompoundDrawablesWithIntrinsicBounds(null, null, headerViewHolder.arrowDown, null)
        }
    }

    private fun bindUserViewHolder(holder: RecyclerView.ViewHolder, viewType: Main_Exp_ViewType) {
        val dataIndex = viewType.dataIndex
        (holder as Main_Exp_UserViewHolder).username.setText(usersList!![dataIndex].name)

//        Glide.with(holder.itemView).load(usersList!![dataIndex].imageUrl)
//            .into((holder as Main_Exp_UserViewHolder).userAvatar)
//
        Picasso.get()
            .load(usersList!![dataIndex].imageUrl)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
            .into((holder as Main_Exp_UserViewHolder).userAvatar)

        holder.expItem.id = dataIndex
        holder.expItem.setOnClickListener(this)
    }

    override fun getItemCount(): Int {
        var count = 0
        if (userTypeList != null && usersList != null) {
            viewTypes!!.clear()
            var collapsedCount = 0
            for (i in userTypeList!!.indices) {
                viewTypes!!.put(count, Main_Exp_ViewType(i, HEADER_TYPE))
                count += 1
                val userType = userTypeList!![i]
                val childCount = getChildCount(userType)
                if (headerExpandTracker!!.get(i) != 0) {
                    // Expanded State
                    for (j in 0 until childCount) {
                        viewTypes!!.put(count, Main_Exp_ViewType(count - (i + 1) + collapsedCount, USER_TYPE))
                        count += 1
                    }
                } else {
                    // Collapsed
                    collapsedCount += childCount
                }
            }
        }
        return count
    }

    override fun getItemViewType(position: Int): Int {
        return if (viewTypes!!.get(position).type === HEADER_TYPE) {
            HEADER_TYPE
        } else {
            USER_TYPE
        }
    }

    private fun getChildCount(type: String): Int {
        when (type) {
            "TYPE-A" -> return 5
            "TYPE-B" -> return 5
            "TYPE-C" -> return 5
            "TYPE-D" -> return 4
            else -> return 0
        }
    }

    fun setUserListAndType(usersList: List<Main_Exp_User>, userTypeList: List<String>?) {
        if (usersList != null && userTypeList != null) {
            this.usersList = usersList
            this.userTypeList = userTypeList
            viewTypes = SparseArray<Main_Exp_ViewType>(usersList.size + userTypeList.size)
            headerExpandTracker = SparseIntArray(userTypeList.size)
            notifyDataSetChanged()
        }
    }

    override fun onHeaderClick(position: Int) {
        val viewType = viewTypes!!.get(position)
        val dataIndex = viewType.dataIndex
        val userType = userTypeList!![dataIndex]
        val childCount = getChildCount(userType)
        if (headerExpandTracker!!.get(dataIndex) == 0) {
            // Collapsed. Now expand it
            headerExpandTracker!!.put(dataIndex, 1)
            notifyItemRangeInserted(position + 1, childCount)
        } else {
            // Expanded. Now collapse it
            headerExpandTracker!!.put(dataIndex, 0)
            notifyItemRangeRemoved(position + 1, childCount)
        }
    }

    override fun isExpanded(position: Int): Boolean {
        val dataIndex = viewTypes!!.get(position).dataIndex
        return headerExpandTracker!!.get(dataIndex) == 1
    }

    companion object {
        private val USER_TYPE = 1
        private val HEADER_TYPE = 2
    }


    override fun onClick(view: View?) {
        val nextIntent = Intent(context, DetailActivity_Test::class.java)
        val putExtra = nextIntent.putExtra("testId", view!!.id.toString())
        view!!.context.startActivity(nextIntent)
    }
}
