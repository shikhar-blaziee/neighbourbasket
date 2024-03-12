package com.blaziee.blaziee.adaptar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.car.ui.toolbar.MenuItem.OnClickListener
import com.blaziee.blaziee.databinding.MenuItemBinding
import com.blaziee.blaziee.detailsActivity
import com.blaziee.blaziee.shopdetailsActivity

@Suppress("DEPRECATION")
class MenuAdapter(private val menuItemsName: List<String>, private val menuItemPrice: List<String>, private val MenuImage: List<Int>, private val requireContext:Context) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private val itemClickListener:OnClickListener ?=null
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
    val binding=MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
    holder.bind(position)
    }
    override fun getItemCount(): Int =menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
                // set on click listner
                val intent = Intent(requireContext, shopdetailsActivity::class.java)
                intent.putExtra("menuItemsName", menuItemsName.get(position))
                intent.putExtra("DetailShopImage", MenuImage.get(position))
                requireContext.startActivity(intent)
            }
        }
            fun bind(position: Int) {
                binding.apply {
                    menuFoodName.text = menuItemsName[position]
                    menuPrice.text = menuItemPrice[position]
                    menuImage.setImageResource(MenuImage[position])


                }
            }

        }
    interface OnClickListener{
        fun onItemClick(position: Int)
    }


}

