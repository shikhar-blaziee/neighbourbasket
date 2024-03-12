package com.blaziee.blaziee.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blaziee.blaziee.databinding.ActivityStartBinding
import com.blaziee.blaziee.databinding.CartitemBinding

    class cartAdaptar( private val cartItems:MutableList<String>,private val cartItemprice: MutableList<String>,private var CartImage:MutableList<Int>): RecyclerView.Adapter<cartAdaptar.cartviewHolder>() {
    private val itemquantities= IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartviewHolder {
    val binding=CartitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
     return cartviewHolder(binding)
    }

    override fun onBindViewHolder(holder: cartviewHolder, position: Int) {
    holder.bind(position)
        }
        override fun getItemCount(): Int =cartItems.size

        inner class cartviewHolder(private val binding:CartitemBinding):RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int) {
                binding.apply {
                    val quantity=itemquantities[position]
                    cartfoodname.text=cartItems[position]
                    cartitemprice.text=cartItemprice[position]
                    cartimage.setImageResource(CartImage[position])
                    cartitemquantity.text=quantity.toString()

                    minusbutton.setOnClickListener{
                        decreaseQuantity(position)

                    }
                    plusbutton.setOnClickListener {
                        increaseQuantity(position)
                    }
                    deleteButton.setOnClickListener {
                        val itemPostion=adapterPosition
                        if(itemPostion != RecyclerView.NO_POSITION){
                            deleteitem(position)
                        }
                    }

                }

            }
            private fun decreaseQuantity(position: Int) {
                if (itemquantities[position] > 1) {
                    itemquantities[position]--
                    binding.cartitemquantity.text=itemquantities[position].toString()
                }
            }
            private fun increaseQuantity(position: Int) {
                if (itemquantities[position] < 10) {
                    itemquantities[position]++
                    binding.cartitemquantity.text=itemquantities[position].toString()
                }
            }
            private fun deleteitem(position: Int) {
                cartItems.removeAt(position)
                cartItemprice.removeAt(position)
                CartImage.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,cartItems.size)

            }

        }
}