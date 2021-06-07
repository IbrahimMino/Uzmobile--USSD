package com.example.uzmobile.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.uzmobile.internetfragments.HaftalikInternetFragment
import com.example.uzmobile.internetfragments.KunlikInternetFragment
import com.example.uzmobile.internetfragments.OylikInternetFragment
import com.example.uzmobile.internetfragments.YillikInternetFragment

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    val fragments: MutableList<Fragment> = ArrayList()
    val titles: MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
       when(position){
           0-> return KunlikInternetFragment()
           1-> return HaftalikInternetFragment()
           2-> return OylikInternetFragment()
           3-> return YillikInternetFragment()
       }
        return KunlikInternetFragment()
    }

    override fun getCount(): Int {
     return fragments.size
    }

    fun addFragment(fragment:Fragment, title:String){
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}