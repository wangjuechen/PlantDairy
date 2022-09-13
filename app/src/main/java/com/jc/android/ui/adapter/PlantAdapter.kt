package com.jc.android.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jc.android.plantdairy.R


class PlantAdapter(val plantList: List<String>) : RecyclerView.Adapter<PlantViewHolder>() {

    var plantClickListener: PlantClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(View.inflate(parent.context, R.layout.item_plant_list, null))
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plantList[position]
        holder.openButton.setOnClickListener {
            plantClickListener?.onClickPlant(plant)
        }
        holder.nameTextView.text = plant
    }

    override fun getItemCount(): Int {
       return plantList.size
    }
}

interface PlantClickListener {
    fun onClickPlant(plant: String)
}

class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val openButton: Button = itemView.findViewById(R.id.button_plant)
    val nameTextView: TextView = itemView.findViewById(R.id.textview_plant)
}