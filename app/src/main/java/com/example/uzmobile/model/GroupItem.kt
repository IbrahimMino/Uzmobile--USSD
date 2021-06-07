package com.example.uzmobile.model

import android.widget.Button
import android.widget.ImageView

class GroupItem(var header: Header,var subItem:SubItem) {

    class Header(val img:Int, val txtHeader:String, val textDesc:String, val imgBtn:Int)
    class SubItem(val subText:String)

    }