package com.blaziee.blaziee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blaziee.blaziee.databinding.ActivityLoginBinding
import com.blaziee.blaziee.databinding.ActivitySignBinding
class SignActivity : AppCompatActivity() {
    private val binding: ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.alreadyButton.setOnClickListener{
            val intent=Intent(this,loginActivity::class.java)
            startActivity(intent)

        }
        binding.loginButton.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}