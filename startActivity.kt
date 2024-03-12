package com.blaziee.blaziee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blaziee.blaziee.databinding.ActivityStartBinding

class startActivity : AppCompatActivity() {
    private val binding:ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            val intent= Intent(this,loginActivity::class.java)
            startActivity(intent)
        }
    }
}