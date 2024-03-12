package com.blaziee.blaziee.fragment

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.blaziee.blaziee.MenuBottomSheetFragment
import com.blaziee.blaziee.R
import com.blaziee.blaziee.adaptar.PopularAdaptar
import com.blaziee.blaziee.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class homeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)

        binding.viewAllMenu.setOnClickListener{
            val bottomsheetdialog= MenuBottomSheetFragment()
            bottomsheetdialog.show(parentFragmentManager,"Test")
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList=ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider=binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object:ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition=imageList[position]
                val itemMessage="Selected image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })
        val storeName= listOf("Gupta store","Raju store","V-Mart","Chemist shop","Big Bazar","Raju Pann Bhandar","Jio mart","Sharma General store")
        val rate = listOf("4.5★","4.2★","4.9★","5★","4★","4.1★","4.6★","4★")
        val shop =listOf(R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4 ,R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4)
        val adaptar=PopularAdaptar(storeName,rate,shop,requireContext())
        binding.Recyclerview.layoutManager=LinearLayoutManager(requireContext())
        binding.Recyclerview.adapter=adaptar
    }

}