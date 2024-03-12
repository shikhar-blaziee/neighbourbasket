package com.blaziee.blaziee.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.blaziee.blaziee.R
import com.blaziee.blaziee.adaptar.MenuAdapter
import com.blaziee.blaziee.databinding.FragmentSearchBinding

class searchFragment : Fragment() {
   private lateinit var binding: FragmentSearchBinding
   private lateinit var adapter:MenuAdapter
   private val originalMenuFoodName= listOf("Gupta store","Raju store","V-Mart","Chemist shop","Big Bazar","Raju Pann Bhandar","Jio mart","Sharma General store","Gupta store","Raju store")
    val originalMenuItemPrice=listOf("4.5★","4.2★","4.9★","5★","4★","4.1★","4.6★","4★","4.5★","4.2★")
    val orignialMenuImage=listOf(R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4 ,R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4,R.drawable.shop1,R.drawable.shop2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
private val filteredMenuFoodName=mutableListOf<String>()
private val filteredMenuItemPrice=mutableListOf<String>()
private val filteredMenuImage=mutableListOf<Int>()
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {
        // Inflate the layout for this fragment
        binding=FragmentSearchBinding.inflate(inflater,container,false)

        adapter= MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage,requireContext())
        binding.menuRecyclerview.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecyclerview.adapter=adapter

        setupSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()
        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(orignialMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }
        })
    }

    private fun filterMenuItem(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query,ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(orignialMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}







