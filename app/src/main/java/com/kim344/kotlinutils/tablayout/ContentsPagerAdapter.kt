package com.kim344.kotlinutils.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ContentsPagerAdapter : FragmentPagerAdapter {

    // 객체 생성
    var fragmentBook : Fragment = FragmentBook()
    var fragmentGame : Fragment = FragmentGame()
    var fragmentHome : Fragment = FragmentHome()
    var fragmentMovie : Fragment = FragmentMovie()
    var fragmentNews : Fragment = FragmentNews()

    var mFragmentList : ArrayList<Fragment> = arrayListOf(fragmentBook,fragmentGame,fragmentHome,fragmentMovie,fragmentNews)

    constructor(fm: FragmentManager) : super(fm)

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}