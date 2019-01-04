package com.example.sunginhong.sideproject_00

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class Main_PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm)
{
    val PAGE_MAX_CNT = 4

    override fun getCount(): Int {
        return PAGE_MAX_CNT
    }

    override fun getItem(position: Int): Fragment? {
        val fragment = when(position)
        {
            1 -> Main_Fragment_Page2().newInstance()
            2 -> Main_Fragment_Page3().newInstance()
            3 -> Main_Fragment_Page4().newInstance()
            else -> Main_Fragment_Page1().newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            1 -> "one"
            2 -> "tow"
            3 -> "three"
            else -> "main"
        }
        return title
    }
}