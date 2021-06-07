package com.example.uzmobile.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.uzmobile.minut.HaftalikMinutFragment
import com.example.uzmobile.minut.KunlikMinutFragment
import com.example.uzmobile.minut.OylikMinutFragment
import com.example.uzmobile.minut.YillikMinutFragment


class ViewPagerAdapterMinut(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    val fragments: MutableList<Fragment> = ArrayList()
    val titles: MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return KunlikMinutFragment()
            1-> return HaftalikMinutFragment()
            2-> return OylikMinutFragment()
            3-> return YillikMinutFragment()
        }
        return KunlikMinutFragment()
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addFragment(fragment: Fragment, title:String){
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}