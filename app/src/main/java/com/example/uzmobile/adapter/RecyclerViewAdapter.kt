package com.example.uzmobile.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uzmobile.R
import com.example.uzmobile.model.GroupItem
var isExpanded = false
lateinit var mContext:Context
class RecyclerViewAdapter(private val groupItem: GroupItem, val context: Context):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    init {
        mContext = context
    }
    companion object{
        const val  VIEW_HEADER = 0
        const val  VIEW_SUB = 1
    }


    sealed class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        class HeaderViewHolder(itemView: View): ViewHolder(itemView){
            private val headerTextView = itemView.findViewById<TextView>(R.id.tv_head_title)
            private val headerDescTextView = itemView.findViewById<TextView>(R.id.tv_head_desc)
            private val headerImageView = itemView.findViewById<ImageView>(R.id.img_head)
            private val headerImageBtn = itemView.findViewById<ImageView>(R.id.imgBtn)

            fun onBind(header: GroupItem.Header, onClickListener: View.OnClickListener){
              headerTextView.text = header.txtHeader
                headerDescTextView.text = header.textDesc
              headerImageView.setImageResource(header.img)
                itemView.setOnClickListener {
                    view ->
                    onClickListener.onClick(view)
                }


                if (!isExpanded){
                    headerImageBtn.setImageResource(R.drawable.ic_down)
                }else{
                    headerImageBtn.setImageResource(R.drawable.ic_up)
                }
            }
        }

       class SubViewHolder(itemView: View): ViewHolder(itemView){
           private var btn_connect = itemView.findViewById<Button>(R.id.btn_connect_sub)
           fun onBind(item: GroupItem.SubItem,onClickListener: View.OnClickListener){
               btn_connect.setOnClickListener { view->
                   onClickListener.onClick(view)
               }
           }
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
             VIEW_HEADER -> {
                 ViewHolder.HeaderViewHolder(layoutInflater.inflate(R.layout.header_item,parent,false))
             }
            else ->{
                ViewHolder.SubViewHolder(layoutInflater.inflate(R.layout.sub_item,parent,false))
            }
        }


    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is ViewHolder.HeaderViewHolder -> holder.onBind(groupItem.header, onHeaderClick())
            is ViewHolder.SubViewHolder -> holder.onBind(groupItem.subItem,onSubClicked(position-1))
        }

    }



    private fun onSubClicked(position: Int)=View.OnClickListener{
        if (isExpanded){
            mContext.startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "*10$position#", null)))
        }
    }
    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            VIEW_HEADER
        }else{
            VIEW_SUB
        }
    }

    private fun onHeaderClick() = View.OnClickListener {
        isExpanded = !isExpanded
       if (isExpanded){
           notifyItemRangeInserted(1,1)
       notifyItemChanged(0)
    }else{
           notifyItemRangeRemoved(1,1)
           notifyItemChanged(0)
       }
    }

}