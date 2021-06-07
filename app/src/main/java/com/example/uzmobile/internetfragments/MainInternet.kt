package com.example.uzmobile.internetfragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.uzmobile.R
import com.example.uzmobile.adapter.RecyclerViewAdapter
import com.example.uzmobile.fragments.PageFragment
import com.example.uzmobile.adapter.ViewPagerAdapter
import com.example.uzmobile.adapter.mContext
import com.example.uzmobile.model.GroupItem
import com.google.android.material.tabs.TabLayout



class MainInternet : Fragment() {
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_internet, container, false)

        viewPagerAdapter = ViewPagerAdapter(fragmentManager!!)

        val adapter = viewPagerAdapter
        adapter.addFragment(KunlikInternetFragment(),"Kunlik")
        adapter.addFragment(HaftalikInternetFragment(),"Hafta")
        adapter.addFragment(OylikInternetFragment(),"Oylik")
        adapter.addFragment(YillikInternetFragment(),"Yillik")

        val viewpager = view.findViewById<ViewPager>(R.id.viewPager)
        tabLayout =  view.findViewById<TabLayout>(R.id.tabLayout)
        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)
         //Margin tablayout item ga
         setMarginOnTabItems()

        val btn_back = view.findViewById<ImageView>(R.id.internet_back)
        btn_back.setOnClickListener {
         fragmentManager!!.beginTransaction().replace(R.id.frame_container,PageFragment()).commit()
        }



      //Trafikni tekshir Button
        val button_trafik = view.findViewById<Button>(R.id.btn_trafik)
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