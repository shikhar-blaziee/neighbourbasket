package com.blaziee.blaziee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blaziee.blaziee.databinding.ActivityDetailsBinding
import com.blaziee.blaziee.databinding.ActivityShopdetailsBinding

class shopdetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopdetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopdetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shopName=intent.getStringExtra("menuItemsName")
        val shopImage=intent.getIntExtra("DetailShopImage",0)
        binding.detailsShopName.text=shopName
        binding.DetailShopImage.setImageResource(shopImage)

        binding.imageButton4.setOnClickListener{
            finish()
}}}