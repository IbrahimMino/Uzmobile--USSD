package com.example.uzmobile.minut

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uzmobile.R
import com.example.uzmobile.adapter.RecyclerViewAdapter
import com.example.uzmobile.model.GroupItem

class KunlikMinutFragment : Fragment() {
    val listOfMinut:MutableList<String> = arrayListOf(
        "10 Daqiqa",
        "20 Daqiqa",
        "30 Daqiqa",
        "40 Daqiqa",
        "50 Daqiqa",
        "60 Daqiqa",
        "70 Daqiqa",
        "80 Daqiqa",
        "90 Daqiqa",
        "100 Daqiqa"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_kunlik_minut, container, false)
        //AdapterList
        val adapterList = arrayListOf<RecyclerViewAdapter>()

        val groupList = createItems(listOfMinut.size)
        for (item in groupList){
            val adapter = RecyclerViewAdapter(item,requireContext())
            adapterList.add(adapter)
        }

        val conCatAdapter = ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build()
        val adapter6 = ConcatAdapter(conCatAdapter,adapterList)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter6




        return view
    }

    fun createItems(numberOfHeaders:Int): List<GroupItem>{
        val groupList = arrayListOf<GroupItem>()
        for (i in 0 until numberOfHeaders){
            val txtHeader = "Header $i"
            val header = GroupItem.Header(R.drawable.nobackuz,listOfMinut[i],getString(R.string.stringg),R.drawable.ic_down)
            val subItem = GroupItem.SubItem("Button")
            val groupItem = GroupItem(header,subItem)
            groupList.add(groupItem)
        }

        return groupList

    }


}