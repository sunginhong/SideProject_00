package com.example.sunginhong.sideproject_00

import android.content.Context
import android.content.Intent
import android.support.v4.util.Pools
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sunginhong.sideproject_00.Model_User.Main_User_min
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import java.util.*



class Main_ViewPagerAdapter_Page1(val context: Context, val userList:ArrayList<Main_User_min>) :
    PagerAdapter(), View.OnClickListener {
    internal var items: MutableList<String> = ArrayList()
    private val mInflater: LayoutInflater
    private val mMyViewPool: Pools.SimplePool<View>
    internal var frag0_VpArray = arrayOfNulls<String>(100)

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
//        Glide.with(mainVp_imageThumb.getContext()).clear(mainVp_imageThumb)
//        Glide.with(context).load(userList[position].imgThumb_Url)
//            .apply(
//                RequestOptions()
//                    .placeholder(R.mipmap.ic_launcher)
//                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//            )
//
//            .into(mainVp_imageThumb)
        Picasso.get()
            .load(userList[position].imgThumb_Url)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
            .into(mainVp_imageThumb)

        (container as ViewPager).addView(view, position)

        mainVp_imageThumb.id = position
        mainVp_imageThumb.setOnClickListener(this);
        frag0_VpArray[position] = userList[position].title

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

    override fun onClick(view: View) {
        val nextIntent = Intent(context, DetailActivity_Test::class.java)
        val putExtra = nextIntent.putExtra("testId", frag0_VpArray[view!!.id])
        view!!.context.startActivity(nextIntent)
    }
}

