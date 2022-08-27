package com.jc.android.plantdairy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jc.android.plantdairy.R
import com.jc.android.plantdairy.UserData

class ItemAdapter(
    private val context: Context,
    private val dataset: List<UserData>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    //position for all recycleview size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val userdata = dataset[position]
        holder.textView.text = userdata.name
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}