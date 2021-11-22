package com.kitesoft.kotlinbnvfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2

class Tab2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    lateinit var pager:ViewPager2
    val items:ArrayList<Int> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        items.add(R.drawable.g_01)
        items.add(R.drawable.g_02)
        items.add(R.drawable.g_03)
        items.add(R.drawable.g_04)
        items.add(R.drawable.g_05)
        items.add(R.drawable.g_06)
        items.add(R.drawable.g_07)

        pager= view.findViewById(R.id.pager)
        pager.adapter= Tab2PagerAdapter(activity as FragmentActivity, items)

    }

}