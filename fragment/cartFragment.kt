package com.blaziee.blaziee.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blaziee.blaziee.CongratsBottomSheet
import com.blaziee.blaziee.PayOutActivity
import com.blaziee.blaziee.R
import com.blaziee.blaziee.adaptar.cartAdaptar
import com.blaziee.blaziee.databinding.CartitemBinding
import com.blaziee.blaziee.databinding.FragmentCartBinding
import com.blaziee.blaziee.startActivity

class cartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container, false)
        val cartFoodName= listOf("Wheat","Rice","Flour","Vegetable","fruit","Wheat","Rice","Flour","Vegetable","fruit")
        val cartItemPrice= listOf("40","45","30","60","80","40","45","30","60","80")
        val cartImage= listOf(
            R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5
        )
        val adapter=cartAdaptar(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartrecyclerview.layoutManager=LinearLayoutManager(requireContext())
        binding.cartrecyclerview.adapter=adapter
        binding.proceeButton.setOnClickListener{
            val intent=Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {

    }
}