package com.jc.android.plantdairy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jc.android.plantdairy.R
import com.jc.android.plantdairy.UserData

class ItemAdapter(
    private val dataset: List<UserData>,
    private val clickToDetailActivityInAdapter: (Int) -> Unit
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.plant_text)
        val buttonDetail: Button = view.findViewById(R.id.view_detail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.plant_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    //position for all recycleview size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val userdata = dataset[position]
        holder.textView.text = userdata.name

        holder.buttonDetail.text = "Ok"
        holder.buttonDetail.setOnClickListener {
            clickToDetailActivityInAdapter(position)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}