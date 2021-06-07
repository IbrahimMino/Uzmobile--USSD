package com.example.uzmobile.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.uzmobile.R
import com.example.uzmobile.adapter.AdapterBan
import com.example.uzmobile.adapter.OnItemClicked
import com.example.uzmobile.banner.BannerItem
import com.example.uzmobile.internetfragments.MainInternet
import com.example.uzmobile.minut.MainMinutFragment
import com.example.uzmobile.smspaketlar.MainSmsFragment
import com.example.uzmobile.trafikfragment.TariflarFragment
import com.example.uzmobile.ussdkodlar.USSDFragment
import com.example.uzmobile.xizmatlar.XizmatlarFragment
import android.os.CountDownTimer as CountDownTimer1


class PageFragment : Fragment(),OnItemClicked{

    lateinit var indicatorContainer: LinearLayout
    lateinit var viewPagerBannerMain:ViewPager2
    lateinit var view2:View
    lateinit var adapterBan: AdapterBan
 var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         view2 = inflater.inflate(R.layout.fragment_page, container, false)

        //Internet activity
        val btn_internet = view2.findViewById<ImageView>(R.id.btn_internet)
        btn_internet.setOnClickListener {
            val manager = fragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.frame_container,MainInternet())?.addToBackStack("HomeFragment")?.commit()
        }

        //Tariflar fragment
        val btn_tarif = view2.findViewById<ImageView>(R.id.btn_tariflarr)
        btn_tarif.setOnClickListener {
            val manager = fragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.frame_container,TariflarFragment())?.addToBackStack("Tariflar fragment")?.commit()
        }
          //SMS fragment
        //Tariflar fragment
        val btn_sms = view2.findViewById<ImageView>(R.id.btn_smss)
        btn_sms.setOnClickListener {
            val manager = fragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.frame_container,MainSmsFragment())?.addToBackStack("SMS fragment")?.commit()
        }

        //USSD fragment
        val btnussd = view2.findViewById<ImageView>(R.id.btn_ussdd)
        btnussd.setOnClickListener {
            val manager = fragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.frame_container,USSDFragment())?.addToBackStack("USSD fragment")?.commit()
        }

        //Xizmat fragment
        val btnXizmat = view2.findViewById<ImageView>(R.id.btn_xizmaatt)
        btnXizmat.setOnClickListener {
            val manager = fragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.frame_container,XizmatlarFragment())?.addToBackStack("Xizmat fragment")?.commit()
        }

        //Phone fragment
        val btnPhone = view2.findViewById<ImageView>(R.id.btn_phone)
        btnPhone.setOnClickListener {
            val manager = fragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.frame_container,MainMinutFragment())?.addToBackStack("Phone fragment")?.commit()
        }


        //Telegam share
        val btnTelegram = view2.findViewById<ImageView>(R.id.share_telegram)
        btnTelegram.setOnClickListener {
            //requireContext().startActivity(Intent(context,Intent.ACTION_VIEW,"http://google.com"))
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://t.me/Ibrokhimjon_Mirzakarimov")
            startActivity(intent)
        }

        //Share
        val btnShare = view2.findViewById<ImageView>(R.id.btn_share)
        btnShare.setOnClickListener {
            //requireContext().startActivity(Intent(context,Intent.ACTION_VIEW,"http://google.com"))
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://google.com")
            startActivity(intent)
        }



        //Banner with ViewPager
        viewPagerBannerMain = view2.findViewById<ViewPager2>(R.id.viewPagerMain2)
        setBannerAdapter()
        setCurrentItem(0)

       var viewPagerCountDownTimer = object : CountDownTimer1(Long.MAX_VALUE, 4000) {
            override fun onTick(p0: Long) {
//                Log.d("POSN", " ${view_pager_flipper.currentItem}+ ${p0/1000} ")

            }

            override fun onFinish() {
            }
        }.start()

        adapterBan.setOnItemClicked(object : OnItemClicked{
            override fun onItemClicked(position: Int) {
                val bundle = Bundle()
                bundle.putInt("POS",position)
                val bannerFragment = BannerFragment()
                bannerFragment.arguments = bundle
                fragmentManager?.beginTransaction()?.replace(R.id.frame_container,bannerFragment)?.addToBackStack("HomePage")?.commit()
            }
        })


        return view2
    }

    fun setBannerAdapter(){
        val listBanner:MutableList<BannerItem> = mutableListOf(
                BannerItem("Oddiy 10","10","10","10","10000"),
                BannerItem("Flash","20","10","10","20000"),
                BannerItem("Street","30","10","10","30000"),
                BannerItem("Royal","40","10","10","40000"),
                BannerItem("Online","50","10","10","50000"),
                BannerItem("Oddiy 60","60","10","10","60000"),
                BannerItem("Oddiy 70","70","10","10","70000"),
                BannerItem("Oddiy 80","80","10","10","80000"),
                BannerItem("Oddiy 90","90","10","10","90000")
        )
         adapterBan = AdapterBan(listBanner,this)


        viewPagerBannerMain.adapter = adapterBan
        setUpIndicatorMain()
        viewPagerBannerMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentItem(position)
            }
        })





    }


    private fun setUpIndicatorMain(){
        indicatorContainer = view2.findViewById<LinearLayout>(R.id.indicatorContainer)
        val indicators = arrayOfNulls<ImageView>(adapterBan.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                WRAP_CONTENT, WRAP_CONTENT
        )

        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(requireContext())
            indicators[i]?.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.indicators_inactive))
            indicators[i]?.layoutParams = layoutParams
            indicatorContainer.addView(indicators[i])
        }
    }
    private fun setCurrentItem(position:Int) {
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount) {
            val indicator = indicatorContainer.getChildAt(i) as ImageView
            if (i == position) {
                indicator.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.indicators_active))
            } else {
                indicator.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.indicators_inactive))
            }
        }
    }

    override fun onItemClicked(position: Int) {
        count = position
    }


}