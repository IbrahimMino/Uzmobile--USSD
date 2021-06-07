package com.example.uzmobile.smspaketlar

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
import com.example.uzmobile.adapter.ViewPagerAdapter
import com.example.uzmobile.adapter.ViewPagerAdapterSms
import com.example.uzmobile.fragments.PageFragment
import com.example.uzmobile.internetfragments.HaftalikInternetFragment
import com.example.uzmobile.internetfragments.KunlikInternetFragment
import com.example.uzmobile.internetfragments.OylikInternetFragment
import com.example.uzmobile.internetfragments.YillikInternetFragment
import com.google.android.material.tabs.TabLayout

class MainSmsFragment : Fragment() {
    lateinit var viewPagerAdapter2: ViewPagerAdapterSms
    lateinit var tabLayout2: TabLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_sms, container, false)
        viewPagerAdapter2 = ViewPagerAdapterSms(fragmentManager!!)

        val adapter = viewPagerAdapter2
        adapter.addFragment(KunlikSmsFragment(),"Kunlik")
        adapter.addFragment(HaftalikSmsFragment(),"Hafta")
        adapter.addFragment(OylikSmsFragment(),"Oylik")
        adapter.addFragment(YillikSmsFragment(),"Yillik")

        val viewpager2 = view.findViewById<ViewPager>(R.id.viewPager2)
        tabLayout2 =  view.findViewById<TabLayout>(R.id.tabLayout2)
        viewpager2.adapter = adapter
        tabLayout2.setupWithViewPager(viewpager2)
        //Margin tablayout item ga
        setMarginOnTabItems()

        val btn_back = view.findViewById<ImageView>(R.id.sms_back)
        btn_back.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.frame_container, PageFragment()).commit()
        }



        //Trafikni tekshir Button
        val btn_sms = view.findViewById<Button>(R.id.btn_sms)
        btn_sms.setOnClickListener {
            requireContext().startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "*107#", null)))
        }




        return view
    }

    fun setMarginOnTabItems() {
        for (i in 0 until tabLayout2.tabCount) {
            val tabItem = (tabLayout2.getChildAt(0) as ViewGroup).getChildAt(i)
            val params = tabItem.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(20, 0, 20, 0)
        }
    }
}