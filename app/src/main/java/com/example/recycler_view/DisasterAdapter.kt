package com.example.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.databinding.ItemDisasterBinding

typealias onClickDisaster = (Disaster) -> Unit

class DisasterAdapter(private val listDisaster: List<Disaster>, private val
    onClickDisaster: onClickDisaster):
    RecyclerView.Adapter<DisasterAdapter.itemDisasterViewHolder>(){
    inner class itemDisasterViewHolder (private val binding
        :ItemDisasterBinding):RecyclerView.ViewHolder(binding.root){

            fun bind(data: Disaster){
                with(binding){
                    txtDisasterName.text = data.nameDisaster
                    txtDisasterType.text = data.typeDisaster
                    itemView.setOnClickListener{
                        onClickDisaster(data)
                    }
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DisasterAdapter.itemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)
        return itemDisasterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DisasterAdapter.itemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }

    override fun getItemCount(): Int = listDisaster.size
}