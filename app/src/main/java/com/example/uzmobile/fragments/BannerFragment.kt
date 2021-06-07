package com.example.uzmobile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.uzmobile.R
import com.example.uzmobile.adapter.AdapterBan
import com.example.uzmobile.adapter.OnItemClicked
import com.example.uzmobile.banner.BannerItem


class BannerFragment : Fragment(){
 lateinit var tarifBan:TextView
 lateinit var phoneMin:TextView
 lateinit var internetMB:TextView
 lateinit var smsTv:TextView
 lateinit var tvPrice:TextView
 lateinit var tvTarif:TextView
 lateinit var tprice:TextView
    lateinit var listBanner:MutableList<BannerItem>

    var param1 = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_banner, container, false)

         tarifBan = view.findViewById<TextView>(R.id.tarif_ban)
         phoneMin = view.findViewById<TextView>(R.id.phone_minut)
         internetMB = view.findViewById<TextView>(R.id.internet_mb)
         smsTv = view.findViewById<TextView>(R.id.sms_banner)
         tvPrice = view.findViewById<TextView>(R.id.tvprice)

        tvTarif = view.findViewById<TextView>(R.id.tv_tarif)
        tprice = view.findViewById<TextView>(R.id.tprice)




         listBanner = mutableListOf(
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



        arguments?.let {
            param1 = it.getInt("POS")
        }

        positionCount(param1)




            return view
    }

   private fun positionCount(p:Int){
       tarifBan.text = listBanner[p].titleBan
       phoneMin.text = listBanner[p].phoneMinut + " MIN"
       internetMB.text = listBanner[p].mbBan + " MB"
       smsTv.text = listBanner[p].smsBan + " SMS"
       tvPrice.text = listBanner[p].priceBan + " сум в месясц"

       tvTarif.text = listBanner[p].titleBan
       tprice.text = listBanner[p].priceBan + " so'm"

   }



}