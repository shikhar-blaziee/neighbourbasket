package com.blaziee.blaziee.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blaziee.blaziee.databinding.NotificationItemBinding

class notificationadaptar(private var notification:ArrayList<String>,private val notificationImage: ArrayList<Int>): RecyclerView.Adapter<notificationadaptar.notificationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notificationViewHolder {
    val binding =NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return notificationViewHolder(binding)
    }


    override fun onBindViewHolder(holder: notificationViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int =notification.size
    inner class notificationViewHolder(private val binding:NotificationItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {
                notificationtextView.text=notification[position]
                notificationimageView.setImageResource(notificationImage[position])
            }


        }
    }
}