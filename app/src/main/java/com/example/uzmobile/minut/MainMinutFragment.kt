package com.example.uzmobile.minut

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.uzmobile.R
import com.example.uzmobile.adapter.ViewPagerAdapterMinut
import com.example.uzmobile.fragments.PageFragment
import com.google.android.material.tabs.TabLayout


class MainMinutFragment : Fragment() {
    lateinit var viewPagerAdapter: ViewPagerAdapterMinut
    lateinit var tabLayout: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_minut, container, false)

        viewPagerAdapter = ViewPagerAdapterMinut(fragmentManager!!)

        val adapter = viewPagerAdapter
        adapter.addFragment(KunlikMinutFragment(),"Kunlik")
        adapter.addFragment(HaftalikMinutFragment(),"Hafta")
        adapter.addFragment(OylikMinutFragment(),"Oylik")
        adapter.addFragment(YillikMinutFragment(),"Yillik")

        val viewpager = view.findViewById<ViewPager>(R.id.viewPager5)
        tabLayout =  view.findViewById<TabLayout>(R.id.tabLayout5)
        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)
        //Margin tablayout item ga
        setMarginOnTabItems()

        val btn_back = view.findViewById<ImageView>(R.id.minut_back)
        btn_back.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.frame_container, PageFragment()).commit()
        }



        //Minutni tekshir Button
        val button_trafik = view.findViewById<Button>(R.id.btn_minut)
        button_trafik.setOnClickListener {
            requireContext().startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "*107#", null)))
        }




        return view
    }

    fun setMarginOnTabItems() {
        for (i in 0 until tabLayout.tabCount) {
            val tabItem = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val params = tabItem.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(20, 0, 20, 0)
        }
    }



}