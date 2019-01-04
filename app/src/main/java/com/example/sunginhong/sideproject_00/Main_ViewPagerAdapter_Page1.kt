package com.example.sunginhong.sideproject_00

import android.content.Context
import android.support.v4.util.Pools
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sunginhong.sideproject_00.Model_User.Main_User_min
import java.util.*

class Main_ViewPagerAdapter_Page1(val context: Context, val userList:ArrayList<Main_User_min>) :
    PagerAdapter() {
    internal var items: MutableList<String> = ArrayList()
    private val mInflater: LayoutInflater
    private val mMyViewPool: Pools.SimplePool<View>

    init {
        mInflater = LayoutInflater.from(context)
        mMyViewPool = Pools.SynchronizedPool(MAX_POOL_SIZE)
    }

    fun add(item: String) {
        items.add(item)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return userList.size
    }

    override fun getPageWidth(position: Int): Float {
        return 1.0f
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view: View? = null
        view = mInflater.inflate(R.layout.item_vpfragment_page1, null)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rootView = inflater.inflate(R.layout.item_vpfragment_page1, container, false)

        val mainVp_textTitle = view.findViewById(R.id.mainVp_textTitle) as TextView
        val mainVp_textSubTitle = view.findViewById(R.id.mainVp_textSubTitle) as TextView
        val mainVp_imageThumb = view.findViewById(R.id.mainVp_imageThumb) as ImageView

        mainVp_textTitle.setText(userList[position].title)
        mainVp_textSubTitle.setText(userList[position].subTitle)
        Glide.with(context)
            .load(userList[position].imgThumb_Url)
            .into(mainVp_imageThumb)

        (container as ViewPager).addView(view, position)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        (container as ViewPager).removeView(view as ViewGroup)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    companion object {
        private val MAX_POOL_SIZE = 10
    }

}