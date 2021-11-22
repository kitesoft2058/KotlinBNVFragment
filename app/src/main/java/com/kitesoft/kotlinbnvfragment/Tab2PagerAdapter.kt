package com.kitesoft.kotlinbnvfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//FragmentStateAdapter를 생성자에 필수적으로 FragmentActivity를 전달해 줘야 하기에.. 상속받는 이 액티비티에서 전달해 줄 필요 있음.
class Tab2PagerAdapter constructor(fa: FragmentActivity, var items: ArrayList<Int>) : FragmentStateAdapter(fa) {

    var pages: List<Tab2PageFragment> = items.map { Tab2PageFragment(it) }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return pages.get(position)
    }
}





//보조 생성자를 통해 부모생성자의 필수 파라미터 전달하는 방법
class Tab2PagerAdapter2 : FragmentStateAdapter {

    //var pages: ArrayList<Tab2PageFragment>

    constructor(fa:FragmentActivity, items:ArrayList<Int>):super(fa){
        //pages= items.map { Tab2PageFragment(it) } as ArrayList<Tab2PageFragment>
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }
}