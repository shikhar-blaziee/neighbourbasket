package com.blaziee.blaziee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blaziee.blaziee.databinding.ActivityDetailsBinding

class detailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName=intent.getStringExtra("menuItemsName")
        val foodImage=intent.getIntExtra("MenuItemsimage",0)
        binding.detailsFoodName.text=foodName
        binding.DetailFoodImage.setImageResource(foodImage)

        binding.imageButton4.setOnClickListener{
            finish()
    }
    }
}