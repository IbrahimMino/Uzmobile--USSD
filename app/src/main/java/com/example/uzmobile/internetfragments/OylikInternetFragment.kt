package com.example.uzmobile.internetfragments

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


class OylikInternetFragment : Fragment() {


    val listOfMb:MutableList<String> = arrayListOf(
            "100 MB",
            "150 MB",
            "200 MB",
            "500 MB",
            "1000 MB",
            "2 GB",
            "5 GB",
            "10 GB",
            "50 GB",
            "75 GB"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_oylik_internet, container, false)

        val adapterList = arrayListOf<RecyclerViewAdapter>()

        val groupList = createItems(listOfMb.size)
        for (item in groupList){
            val adapter = RecyclerViewAdapter(item,requireContext())
            adapterList.add(adapter)
        }

        val conCatAdapter = ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build()
        val adapter2 = ConcatAdapter(conCatAdapter,adapterList)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter2




        return view
    }

    fun createItems(numberOfHeaders:Int): List<GroupItem>{
        val groupList = arrayListOf<GroupItem>()
        for (i in 0 until numberOfHeaders){
            val txtHeader = "Header $i"
            val header = GroupItem.Header(R.drawable.nobackuz,listOfMb[i],getString(R.string.stringg),R.drawable.ic_down)
            val subItem = GroupItem.SubItem("Button")
            val groupItem = GroupItem(header,subItem)
            groupList.add(groupItem)
        }

        return groupList

    }
}