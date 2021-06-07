package com.example.uzmobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uzmobile.R
import com.example.uzmobile.banner.BannerItem
import kotlinx.android.synthetic.main.banneritem.view.*

class AdapterBan(private val introList: List<BannerItem>, listener: OnItemClicked) :
    RecyclerView.Adapter<AdapterBan.IntroViewHolder>() {
    lateinit var listenerAd: OnItemClicked
    init {
        listenerAd = listener
    }
    inner class IntroViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        init {
            itemview.setOnClickListener {

                    listenerAd.onItemClicked(adapterPosition)

            }
        }
        fun onBind(item: BannerItem) {
    itemView.tv_tarif_ban.setText(item.titleBan)
    itemView.phone_minut.setText(item.phoneMinut +" MIN")
    itemView.internet_mb.setText(item.mbBan+" MB")
            itemView.sms_banner.setText(item.smsBan+" SMS")
    itemView.price.setText(item.priceBan+" сум в месясц")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        return IntroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.banneritem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.onBind(introList[position])
    }

    override fun getItemCount(): Int {
        return introList.size
    }
    fun setOnItemClicked(listener: OnItemClicked){
        this.listenerAd =  listener
    }
}
