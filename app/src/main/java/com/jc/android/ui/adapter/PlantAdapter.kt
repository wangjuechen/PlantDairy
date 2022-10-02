package com.jc.android.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jc.android.data.model.MarsPhoto
import com.jc.android.plantdairy.R


class PlantAdapter(var marsPhotos: List<MarsPhoto> = emptyList()) :
    RecyclerView.Adapter<PlantViewHolder>() {

    var plantClickListener: PlantClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(View.inflate(parent.context, R.layout.item_plant_list, null))
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val marsPhoto = marsPhotos[position]
        holder.openButton.setOnClickListener {
            plantClickListener?.onClickPlant(marsPhoto.id)
        }
        holder.nameTextView.text = marsPhoto.id
    }

    override fun getItemCount(): Int {
        return marsPhotos.size
    }

    fun updatePlantList(marsPhotos: List<MarsPhoto>?) {
        this.marsPhotos = marsPhotos ?: emptyList()

        notifyDataSetChanged()
    }
}

interface PlantClickListener {
    fun onClickPlant(plant: String)
}

class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val openButton: Button = itemView.findViewById(R.id.button_plant)
    val nameTextView: TextView = itemView.findViewById(R.id.textview_plant)
}