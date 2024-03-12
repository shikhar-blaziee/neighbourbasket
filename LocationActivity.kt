package com.blaziee.blaziee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.blaziee.blaziee.databinding.ActivityLoactionBinding

class LocationActivity : AppCompatActivity() {
    private val binding:ActivityLoactionBinding by  lazy {
        ActivityLoactionBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList= arrayOf("Hardoi","Gurugram","Delhi","lucknow")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView= binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}