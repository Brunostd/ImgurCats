package com.denybrabo.imgurcats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.denybrabo.imgurcats.databinding.DataBinding
import com.denybrabo.imgurcats.model.AnimalModel
import com.denybrabo.imgurcats.model.DataModel
import com.denybrabo.imgurcats.model.ImagesModel

class DataAdapter(private var data: MutableList<AnimalModel>): RecyclerView.Adapter<DataAdapter.MyViewHolder>() {
    class MyViewHolder(private val itemBinding: DataBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: AnimalModel){
            itemBinding.run {
                data.images?.forEach {
                    var url = it.link
                    Glide.with(itemView.context).load(url).into(this.imageView)
                }
                this.textView.text = data.title
            }
        }
        companion object{
            fun create(parent: ViewGroup): MyViewHolder{
                val itemBinding = DataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MyViewHolder(itemBinding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}