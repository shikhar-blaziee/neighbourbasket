package com.blaziee.blaziee.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blaziee.blaziee.R
import com.blaziee.blaziee.adaptar.historyadaptar
import com.blaziee.blaziee.databinding.FragmentHistoryBinding
import com.blaziee.blaziee.databinding.HistoryitemBinding


class historyFragment : Fragment() {
   private lateinit var binding: FragmentHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater,container,false)
        val historytext= listOf("rice","pulses","biscits","fruit","vegetables","Flour","rice","pulses","biscits","fruit","vegetables","Flour")
        val historytext2= listOf("From Vishal","From Big bazar","From Raju shop","From 24-7","From Gupta Grocery","From sharma bhadar","From big basket","From Grocery","From Raju shop","From Vishal","From big bazar","From 24-7")
        val historytext3= listOf("30-35 min","20-25 min","40-45 min","30-35 min","20-25 min","40-45 min","30-35 min","10-15 min","40-45 min","20-25 min","30-35 min","40-45 min")
        val historytext4= listOf("4.1★","4.2★","4.3★","4.4★","4.5★","4.6★","4.7★","4.8★","4.9★","4.5★","4.6★","4.7★")
        val historyimg= listOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic1,R.drawable.pic5,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic1,R.drawable.pic5)
        val adapter=historyadaptar(ArrayList(historytext),ArrayList(historytext2),ArrayList(historytext3),ArrayList(historytext4),ArrayList(historyimg),requireContext())
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=adapter

        return binding.root
    }

}