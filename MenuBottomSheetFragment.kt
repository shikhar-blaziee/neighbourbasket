package com.blaziee.blaziee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blaziee.blaziee.adaptar.MenuAdapter
import com.blaziee.blaziee.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.buttonBack.setOnClickListener{dismiss()}
        val menuItemsName= listOf("Gupta store","Raju store","V-Mart","Chemist shop","Big Bazar","Raju Pann Bhandar","Jio mart","Sharma General store","Gupta store","Raju store","V-Mart","Chemist shop","Big Bazar","Raju Pann Bhandar","Jio mart","Sharma General store")
        val menuItemPrice = listOf("4.5★","4.2★","4.9★","5★","4★","4.1★","4.6★","4★","4.5★","4.2★","4.9★","5★","4★","4.1★","4.6★","4★")
        val MenuImage =listOf(R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4 ,R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4,R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4 ,R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4)
        val adaptar= MenuAdapter(menuItemsName,menuItemPrice,MenuImage,requireContext())
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adaptar
        return binding.root
    }

    companion object {

    }
}