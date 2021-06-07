package com.example.uzmobile.trafikfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uzmobile.R
import com.example.uzmobile.adapter.RecyclerViewAdapter
import com.example.uzmobile.fragments.PageFragment
import com.example.uzmobile.model.GroupItem

class TariflarFragment : Fragment() {
    val listOTariflar:MutableList<String> = arrayListOf(
        "Oddiy 10",
        "Delovoy",
        "Bolajon",
        "Yoshlar",
        "Traffic",
        "Traffic 2",
        "Silver",
        "Street",
        "Online",
        "Royal"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tariflar, container, false)

        val adapterList = arrayListOf<RecyclerViewAdapter>()

        val groupList = createItems(listOTariflar.size)
        for (item in groupList){
            val adapter = RecyclerViewAdapter(item,requireContext())
            adapterList.add(adapter)
        }

        val conCatAdapter = ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build()
        val adapter2 = ConcatAdapter(conCatAdapter,adapterList)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter2


        //back pressed
        val btn_back = view.findViewById<ImageView>(R.id.tarif_back)
        btn_back.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.frame_container, PageFragment()).commit()
        }



        return view
    }
    fun createItems(numberOfHeaders:Int): List<GroupItem>{
        val groupList = arrayListOf<GroupItem>()
        for (i in 0 until numberOfHeaders){
            val txtHeader = "Header $i"
            val header = GroupItem.Header(R.drawable.nobackuz,listOTariflar[i],getString(R.string.stringg),R.drawable.ic_down)
            val subItem = GroupItem.SubItem("Button")
            val groupItem = GroupItem(header,subItem)
            groupList.add(groupItem)
        }

        return groupList

    }


}