package com.jc.android.plantdairy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jc.android.plantdairy.R
import com.jc.android.plantdairy.data.model.Plant

class ItemAdapter(
    private var dataset: List<Plant> = emptyList()
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var plantClickListener: PlantClickListener? = null

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textview_plant)
        val buttonDetail: Button = view.findViewById(R.id.button_plant)
        val photoImageView: ImageView = itemView.findViewById(R.id.imageview_plant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.plant_list, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val plantItem = dataset[position]
        holder.buttonDetail.setOnClickListener {
            plantClickListener?.onClickPlant(plantItem.id)
        }
        holder.textView.text = plantItem.id.toString()
        //TODO: holder.photoImageView = image from device storage
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun updatePlantList(plants: List<Plant>?) {
        this.dataset = plants ?: emptyList()
        notifyDataSetChanged()
    }
}

interface PlantClickListener {
    fun onClickPlant(plantId: Int)
}