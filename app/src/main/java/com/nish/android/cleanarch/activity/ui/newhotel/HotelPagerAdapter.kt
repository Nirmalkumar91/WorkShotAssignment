package com.nish.android.cleanarch.activity.ui.newhotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HotelPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int  = 2

    override fun getItem(i: Int): Fragment {
        val fragment = if(i == 0) CommentFragment() else NewHotelFragment()
        fragment.arguments = Bundle().apply {

        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if(position == 0) "Comment" else "Hotel Details"
    }
}