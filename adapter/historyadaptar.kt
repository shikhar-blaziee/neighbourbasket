package com.blaziee.blaziee.adaptar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blaziee.blaziee.databinding.HistoryitemBinding
import com.blaziee.blaziee.detailsActivity

class historyadaptar(private val historyitem:MutableList<String>,private val historyitem2:MutableList<String>,private val historyitem3:MutableList<String>,private val historyitem4:MutableList<String>,private val historyimg:MutableList<Int>, private val requireContext: Context): RecyclerView.Adapter<historyadaptar.HistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding=HistoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HistoryViewHolder(binding)
    }

    override fun getItemCount(): Int=historyitem.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(position)
    }
    inner class HistoryViewHolder(private val binding: HistoryitemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                historytext.text=historyitem[position]
                historytext2.text=historyitem2[position]
                historytext3.text=historyitem3[position]
                historytext4.text=historyitem4[position]
                historyimage.setImageResource(historyimg[position])
            }
            binding.root.setOnClickListener {
            val intent = Intent(requireContext, detailsActivity::class.java)
            intent.putExtra("menuItemsName", historyitem.get(position))
            intent.putExtra("MenuItemsimage", historyimg.get(position))
            requireContext.startActivity(intent)}
        }
    }
}