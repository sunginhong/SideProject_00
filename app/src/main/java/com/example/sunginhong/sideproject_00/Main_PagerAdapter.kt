package com.example.sunginhong.sideproject_00

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class Main_PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm)
{
    val PAGE_MAX_CNT = 4
    private val titles = arrayOf("one", "two", "three", "four")

    override fun getCount(): Int {
        return PAGE_MAX_CNT
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return Main_Fragment_Page1().newInstance()
            1 -> return Main_Fragment_Page2().newInstance()
            2 -> return Main_Fragment_Page3().newInstance()
            3 -> return Main_Fragment_Page4().newInstance()
            else -> return null
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return  titles[position]
    }

}

