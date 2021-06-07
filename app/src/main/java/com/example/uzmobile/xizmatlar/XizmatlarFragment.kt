package com.example.uzmobile.xizmatlar

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


class XizmatlarFragment : Fragment() {
    val listOfUssd:MutableList<String> = arrayListOf(
        "Balans",
        "Mega qo'ng'roq qiling",
        "Mening raqamim",
        "Boshqa raqamga yo'naltirish",
        "Vaqticha aloqada emasman",
        "Ko'ngilochar chat",
        "Men kimman",
        "Mega boom",
        "Gudoklar",
        "Yangi raqamlar",
        "Yangilik"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_xizmatlar, container, false)

        val adapterList = arrayListOf<RecyclerViewAdapter>()

        val groupList = createItems(listOfUssd.size)
        for (item in groupList){
            val adapter = RecyclerViewAdapter(item,requireContext())
            adapterList.add(adapter)
        }

        val conCatAdapter = ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build()
        val adapter4 = ConcatAdapter(conCatAdapter,adapterList)
        val recyclerView4 = view.findViewById<RecyclerView>(R.id.recyclerView4)
        recyclerView4.layoutManager = LinearLayoutManager(requireContext())
        recyclerView4.adapter = adapter4


        //back pressed
        val btn_back = view.findViewById<ImageView>(R.id.xizmat_back)
        btn_back.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.frame_container, PageFragment()).commit()
        }


        return view
    }
    fun createItems(numberOfHeaders:Int): List<GroupItem>{
        val groupList = arrayListOf<GroupItem>()
        for (i in 0 until numberOfHeaders){
            val txtHeader = "Header $i"
            val header = GroupItem.Header(R.drawable.nobackuz,listOfUssd[i],getString(R.string.stringg),R.drawable.ic_down)
            val subItem = GroupItem.SubItem("Button")
            val groupItem = GroupItem(header,subItem)
            groupList.add(groupItem)
        }

        return groupList

    }

}