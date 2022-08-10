package com.rico.challenge4.adapter

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rico.challenge4.fragment.FragmentLandingPage1
import com.rico.challenge4.fragment.FragmentLandingPage2
import com.rico.challenge4.fragment.FragmentlandingPage3

class ViewPagerAdapter(fragmentActivity: FragmentActivity):  FragmentStateAdapter(fragmentActivity){

    private val NUM_PAGES = 3

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                FragmentLandingPage1()
            }
            1 -> {
                FragmentLandingPage2()
            }
            else -> {
                FragmentlandingPage3()
            }
        }
    }

}